package com.tjfae.oauthcenter.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 登录验证
 *
 * @Author Kenn.Won
 *
 * @Date 20200501
*/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String memberName) throws UsernameNotFoundException {
////        SysUserVO sysUserVO = userDao.findByUserName(memberName);
//        SysUserVO sysUserVO = new SysUserVO();
//        sysUserVO.setId(1);
//        sysUserVO.setUsername("admin");
//        sysUserVO.setPassword("123");
//        if (sysUserVO == null) {
//            throw new UsernameNotFoundException(memberName);
//        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//
//        Set<SysRole> sysRoles = new HashSet<>();
//
//        // 可用性 :true:可用 false:不可用
//        boolean enabled = true;
//        // 过期性 :true:没过期 false:过期
//        boolean accountNonExpired = true;
//        // 有效性 :true:凭证有效 false:凭证无效
//        boolean credentialsNonExpired = true;
//        // 锁定性 :true:未锁定 false:已锁定
//        boolean accountNonLocked = true;
//        for (SysRole role : sysUserVO.getSysRoles()) {
//            //角色必须是ROLE_开头，可以在数据库中设置
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
//            grantedAuthorities.add(grantedAuthority);
//            //获取权限
//            for (SysPermission permission : role.getSysPermissions()) {
//                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermissionUri());
//                grantedAuthorities.add(authority);
//            }
//        }
//        User user = new User(sysUserVO.getUsername(), sysUserVO.getPassword(),
//                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
//        return user;

        Set<GrantedAuthority> userAuthotities = new HashSet<>();
        userAuthotities.add(new SimpleGrantedAuthority("test1"));
        // 注意如果在WebSecurityConfig.java 中使用的密文时，这个地方也要使用密文
//        return new User("admin", "$2a$10$XOVs4Z1YtPKqKwQVywG9j.xLAqXYRQLGZMGMrZDNbtl6pUC0Weteq", userAuthotities);
        return new User("admin", "123", userAuthotities);
    }
}
