package com.ruoyi.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.TPensionPlan;
import com.ruoyi.project.system.service.ITPensionPlanService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 养老计划Controller
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
@RestController
@RequestMapping("/plan/plan")
public class TPensionPlanController extends BaseController
{
    @Autowired
    private ITPensionPlanService tPensionPlanService;

    /**
     * 查询养老计划列表
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPensionPlan tPensionPlan)
    {
        startPage();
        List<TPensionPlan> list = tPensionPlanService.selectTPensionPlanList(tPensionPlan);
        return getDataTable(list);
    }

    /**
     * 导出养老计划列表
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:export')")
    @Log(title = "养老计划", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TPensionPlan tPensionPlan)
    {
        List<TPensionPlan> list = tPensionPlanService.selectTPensionPlanList(tPensionPlan);
        ExcelUtil<TPensionPlan> util = new ExcelUtil<TPensionPlan>(TPensionPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 获取养老计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:query')")
    @GetMapping(value = "/{planId}")
    public AjaxResult getInfo(@PathVariable("planId") Long planId)
    {
        return AjaxResult.success(tPensionPlanService.selectTPensionPlanById(planId));
    }

    /**
     * 新增养老计划
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:add')")
    @Log(title = "养老计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPensionPlan tPensionPlan)
    {
        return toAjax(tPensionPlanService.insertTPensionPlan(tPensionPlan));
    }

    /**
     * 修改养老计划
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:edit')")
    @Log(title = "养老计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPensionPlan tPensionPlan)
    {
        return toAjax(tPensionPlanService.updateTPensionPlan(tPensionPlan));
    }

    /**
     * 删除养老计划
     */
    @PreAuthorize("@ss.hasPermi('plan:plan:remove')")
    @Log(title = "养老计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planIds}")
    public AjaxResult remove(@PathVariable Long[] planIds)
    {
        return toAjax(tPensionPlanService.deleteTPensionPlanByIds(planIds));
    }
}
