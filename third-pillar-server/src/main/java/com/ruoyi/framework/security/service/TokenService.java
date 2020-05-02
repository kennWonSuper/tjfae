package com.ruoyi.framework.security.service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.domain.SysDept;
import com.ruoyi.project.system.domain.SysRole;
import com.ruoyi.project.system.domain.SysUser;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.IdUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.ip.AddressUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.security.LoginUser;
import eu.bitwalker.useragentutils.UserAgent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * token验证处理
 *
 * @author tjs
 */
@Component
public class TokenService
{
    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Autowired
    private RedisCache redisCache;

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request)
    {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token))
        {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            JSONObject jsonObject = redisCache.getCacheObject(userKey);
            String json = jsonObject.toJSONString();
            System.out.println(json);
            LoginUser user = createLoginUser(jsonObject);
            return user;
        }
        return null;
    }

    private LoginUser createLoginUser(JSONObject jsonObject) {
        LoginUser loginUser = new LoginUser();
        loginUser.setToken((String) jsonObject.get("token"));
        loginUser.setLoginTime((Long) jsonObject.get("loginTime"));
        loginUser.setExpireTime((Long) jsonObject.get("expireTime"));
        loginUser.setIpaddr((String) jsonObject.get("ipaddr"));
        loginUser.setLoginLocation((String) jsonObject.get("loginLocation"));
        loginUser.setBrowser((String) jsonObject.get("browser"));
        loginUser.setOs((String) jsonObject.get("os"));

        Set<String> permissions = (HashSet) jsonObject.get("permissions");
        loginUser.setPermissions(permissions);

        JSONObject user = (JSONObject) jsonObject.get("user");
        SysUser sysUser = new SysUser();
        Integer u = (Integer) user.get("userId");
        Integer d = (Integer) user.get("deptId");
        sysUser.setUserId(u.longValue());
        sysUser.setDeptId(d.longValue());
        sysUser.setUserName((String) user.get("userName"));

        sysUser.setNickName((String) user.get("nickName"));
        sysUser.setEmail((String) user.get("email"));
        sysUser.setPhonenumber((String) user.get("phonenumber"));
        sysUser.setSex((String) user.get("sex"));
        sysUser.setAvatar((String) user.get("avatar"));
        sysUser.setStatus((String) user.get("status"));
        sysUser.setDelFlag((String) user.get("delFlag"));
        sysUser.setLoginIp((String) user.get("loginIp"));
        Long date = (Long) user.get("loginDate");
        sysUser.setLoginDate(new Date(date));

        JSONArray roleArr = (JSONArray) user.get("roles");
        List<SysRole> roles = new ArrayList<>();
        for (Object ro : roleArr) {
            JSONObject r = (JSONObject) ro;
            SysRole sysRole = new SysRole();
            Integer rol = (Integer) r.get("roleId");
            sysRole.setRoleId(rol.longValue());

            sysRole.setRoleName((String) r.get("roleName"));
            sysRole.setRoleKey((String) r.get("roleKey"));
            sysRole.setRoleSort((String) r.get("roleSort"));
            sysRole.setDataScope((String) r.get("dataScope"));
            sysRole.setFlag((Boolean) r.get("flag"));
            roles.add(sysRole);
        }
        sysUser.setRoles(roles);

        JSONObject depto = (JSONObject) user.get("dept");
        SysDept sysDept = new SysDept();
        Integer d1 = (Integer) depto.get("deptId");
        Integer d3 = (Integer) depto.get("parentId");
        sysDept.setDeptId(d1.longValue());
        sysDept.setParentId(d3.longValue());
        sysDept.setDeptName((String) depto.get("deptName"));
        sysDept.setLeader((String) depto.get("leader"));
        sysDept.setOrderNum((String) depto.get("orderNum"));
        sysDept.setStatus((String) depto.get("status"));

        sysUser.setDept(sysDept);

        loginUser.setUser(sysUser);

        return loginUser;
    }

    /**
     * 设置用户身份信息
     */
    public void setLoginUser(LoginUser loginUser)
    {
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNotEmpty(loginUser.getToken()))
        {
            refreshToken(loginUser);
        }
    }

    /**
     * 删除用户身份信息
     */
    public void delLoginUser(String token)
    {
        if (StringUtils.isNotEmpty(token))
        {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser)
    {
        String token = IdUtils.fastUUID();
        loginUser.setToken(token);
        setUserAgent(loginUser);
        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param token 令牌
     * @return 令牌
     */
    public void verifyToken(LoginUser loginUser)
    {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN)
        {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser)
    {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 设置用户代理信息
     *
     * @param loginUser 登录信息
     */
    public void setUserAgent(LoginUser loginUser)
    {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        loginUser.setIpaddr(ip);
        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        loginUser.setBrowser(userAgent.getBrowser().getName());
        loginUser.setOs(userAgent.getOperatingSystem().getName());
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims)
    {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token)
    {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token)
    {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request)
    {
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX))
        {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private String getTokenKey(String uuid)
    {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }
}
