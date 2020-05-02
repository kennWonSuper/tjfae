package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.TOrgInfo;
import com.ruoyi.project.system.domain.vo.CheckVo;
import com.ruoyi.project.system.service.ITOrgInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门Controller
 *
 * @author ruoyi
 * @date 2020-04-14
 */
@Api(tags = "清分机构管理")
@RestController
@RequestMapping("/org/qfen")
public class OrgQfController extends BaseController
{
    @Autowired
    private ITOrgInfoService tOrgInfoService;

    /**
     * 查询部门列表
     */
    @ApiOperation(value = "清分机构审核")
    @PreAuthorize("@ss.hasPermi('qfenorg:check:index')")
    @GetMapping("/check")
    public AjaxResult check(CheckVo checkVo)
    {
        if (checkVo != null && checkVo.getIsPass() != null && checkVo.getIsPass() == 1) {

        }
        return toAjax(tOrgInfoService.check(checkVo));
    }

    /**
     * 查询部门列表
     */
    @PreAuthorize("@ss.hasPermi('qfenorg:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOrgInfo tOrgInfo)
    {
        startPage();
        tOrgInfo.setDeptType("02");
        List<TOrgInfo> list = tOrgInfoService.selectTOrgInfoList(tOrgInfo);
        return getDataTable(list);
    }

    /**
     * 导出部门列表
     */
    @PreAuthorize("@ss.hasPermi('qfenorg:info:export')")
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TOrgInfo tOrgInfo)
    {
        List<TOrgInfo> list = tOrgInfoService.selectTOrgInfoList(tOrgInfo);
        ExcelUtil<TOrgInfo> util = new ExcelUtil<TOrgInfo>(TOrgInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取部门详细信息
     */
    @PreAuthorize("@ss.hasPermi('qfenorg:info:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(tOrgInfoService.selectTOrgInfoById(deptId));
    }

    /**
     * 新增部门
     */
    @PreAuthorize("@ss.hasPermi('qfenorg:info:add')")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOrgInfo tOrgInfo)
    {
        tOrgInfo.setParentId(100L);
        tOrgInfo.setDeptType("02");
        return toAjax(tOrgInfoService.insertTOrgInfo(tOrgInfo));
    }

    /**
     * 修改部门
     */
    @PreAuthorize("@ss.hasPermi('qfenorg:info:edit')")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOrgInfo tOrgInfo)
    {
        return toAjax(tOrgInfoService.updateTOrgInfo(tOrgInfo));
    }

    /**
     * 删除部门
     */
    @PreAuthorize("@ss.hasPermi('qfenorg:info:remove')")
    @Log(title = "部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(tOrgInfoService.deleteTOrgInfoByIds(deptIds));
    }
}
