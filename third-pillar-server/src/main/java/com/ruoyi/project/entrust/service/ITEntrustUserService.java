package com.ruoyi.project.entrust.service;

import java.util.List;
import com.ruoyi.project.entrust.domain.TEntrustUser;

/**
 * 委托人Service接口
 *
 * @author tjs
 * @date 2020-04-19
 */
public interface ITEntrustUserService
{
    /**
     * 查询委托人
     *
     * @param id 委托人ID
     * @return 委托人
     */
    public TEntrustUser selectTEntrustUserById(Long id);

    /**
     * 查询委托人列表
     *
     * @param tEntrustUser 委托人
     * @return 委托人集合
     */
    public List<TEntrustUser> selectTEntrustUserList(TEntrustUser tEntrustUser);

    /**
     * 新增委托人
     *
     * @param tEntrustUser 委托人
     * @return 结果
     */
    public int insertTEntrustUser(TEntrustUser tEntrustUser);

    /**
     * 修改委托人
     *
     * @param tEntrustUser 委托人
     * @return 结果
     */
    public int updateTEntrustUser(TEntrustUser tEntrustUser);

    /**
     * 批量删除委托人
     *
     * @param ids 需要删除的委托人ID
     * @return 结果
     */
    public int deleteTEntrustUserByIds(Long[] ids);

    /**
     * 删除委托人信息
     *
     * @param id 委托人ID
     * @return 结果
     */
    public int deleteTEntrustUserById(Long id);
}
