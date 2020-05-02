package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.TPensionPlan;

/**
 * 养老计划Service接口
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
public interface ITPensionPlanService 
{
    /**
     * 查询养老计划
     * 
     * @param planId 养老计划ID
     * @return 养老计划
     */
    public TPensionPlan selectTPensionPlanById(Long planId);

    /**
     * 查询养老计划列表
     * 
     * @param tPensionPlan 养老计划
     * @return 养老计划集合
     */
    public List<TPensionPlan> selectTPensionPlanList(TPensionPlan tPensionPlan);

    /**
     * 新增养老计划
     * 
     * @param tPensionPlan 养老计划
     * @return 结果
     */
    public int insertTPensionPlan(TPensionPlan tPensionPlan);

    /**
     * 修改养老计划
     * 
     * @param tPensionPlan 养老计划
     * @return 结果
     */
    public int updateTPensionPlan(TPensionPlan tPensionPlan);

    /**
     * 批量删除养老计划
     * 
     * @param planIds 需要删除的养老计划ID
     * @return 结果
     */
    public int deleteTPensionPlanByIds(Long[] planIds);

    /**
     * 删除养老计划信息
     * 
     * @param planId 养老计划ID
     * @return 结果
     */
    public int deleteTPensionPlanById(Long planId);
}
