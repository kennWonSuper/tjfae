package com.ruoyi.project.entrust.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.entrust.mapper.TEntrustUserMapper;
import com.ruoyi.project.entrust.domain.TEntrustUser;
import com.ruoyi.project.entrust.service.ITEntrustUserService;

/**
 * 委托人Service业务层处理
 *
 * @author tjs
 * @date 2020-04-19
 */
@Service
public class TEntrustUserServiceImpl implements ITEntrustUserService
{
    @Autowired
    private TEntrustUserMapper tEntrustUserMapper;

    /**
     * 查询委托人
     *
     * @param id 委托人ID
     * @return 委托人
     */
    @Override
    public TEntrustUser selectTEntrustUserById(Long id)
    {
        return tEntrustUserMapper.selectTEntrustUserById(id);
    }

    /**
     * 查询委托人列表
     *
     * @param tEntrustUser 委托人
     * @return 委托人
     */
    @Override
    public List<TEntrustUser> selectTEntrustUserList(TEntrustUser tEntrustUser)
    {
        return tEntrustUserMapper.selectTEntrustUserList(tEntrustUser);
    }

    /**
     * 新增委托人
     *
     * @param tEntrustUser 委托人
     * @return 结果
     */
    @Override
    public int insertTEntrustUser(TEntrustUser tEntrustUser)
    {
        tEntrustUser.setCreateTime(DateUtils.getNowDate());
        return tEntrustUserMapper.insertTEntrustUser(tEntrustUser);
    }

    /**
     * 修改委托人
     *
     * @param tEntrustUser 委托人
     * @return 结果
     */
    @Override
    public int updateTEntrustUser(TEntrustUser tEntrustUser)
    {
        tEntrustUser.setUpdateTime(DateUtils.getNowDate());
        return tEntrustUserMapper.updateTEntrustUser(tEntrustUser);
    }

    /**
     * 批量删除委托人
     *
     * @param ids 需要删除的委托人ID
     * @return 结果
     */
    @Override
    public int deleteTEntrustUserByIds(Long[] ids)
    {
        return tEntrustUserMapper.deleteTEntrustUserByIds(ids);
    }

    /**
     * 删除委托人信息
     *
     * @param id 委托人ID
     * @return 结果
     */
    @Override
    public int deleteTEntrustUserById(Long id)
    {
        return tEntrustUserMapper.deleteTEntrustUserById(id);
    }
}
