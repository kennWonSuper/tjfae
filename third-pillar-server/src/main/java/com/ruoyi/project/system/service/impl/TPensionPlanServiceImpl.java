package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.TPensionPlanMapper;
import com.ruoyi.project.system.domain.TPensionPlan;
import com.ruoyi.project.system.service.ITPensionPlanService;

/**
 * 养老计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
@Service
public class TPensionPlanServiceImpl implements ITPensionPlanService 
{
    @Autowired
    private TPensionPlanMapper tPensionPlanMapper;

    /**
     * 查询养老计划
     * 
     * @param planId 养老计划ID
     * @return 养老计划
     */
    @Override
    public TPensionPlan selectTPensionPlanById(Long planId)
    {
        return tPensionPlanMapper.selectTPensionPlanById(planId);
    }

    /**
     * 查询养老计划列表
     * 
     * @param tPensionPlan 养老计划
     * @return 养老计划
     */
    @Override
    public List<TPensionPlan> selectTPensionPlanList(TPensionPlan tPensionPlan)
    {
        return tPensionPlanMapper.selectTPensionPlanList(tPensionPlan);
    }

    /**
     * 新增养老计划
     * 
     * @param tPensionPlan 养老计划
     * @return 结果
     */
    @Override
    public int insertTPensionPlan(TPensionPlan tPensionPlan)
    {
        tPensionPlan.setCreateTime(DateUtils.getNowDate());
        return tPensionPlanMapper.insertTPensionPlan(tPensionPlan);
    }

    /**
     * 修改养老计划
     * 
     * @param tPensionPlan 养老计划
     * @return 结果
     */
    @Override
    public int updateTPensionPlan(TPensionPlan tPensionPlan)
    {
        tPensionPlan.setUpdateTime(DateUtils.getNowDate());
        return tPensionPlanMapper.updateTPensionPlan(tPensionPlan);
    }

    /**
     * 批量删除养老计划
     * 
     * @param planIds 需要删除的养老计划ID
     * @return 结果
     */
    @Override
    public int deleteTPensionPlanByIds(Long[] planIds)
    {
        return tPensionPlanMapper.deleteTPensionPlanByIds(planIds);
    }

    /**
     * 删除养老计划信息
     * 
     * @param planId 养老计划ID
     * @return 结果
     */
    @Override
    public int deleteTPensionPlanById(Long planId)
    {
        return tPensionPlanMapper.deleteTPensionPlanById(planId);
    }
}
