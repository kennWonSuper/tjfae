package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.project.system.domain.vo.CheckVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.TOrgInfo;
import com.ruoyi.project.system.service.ITOrgInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 部门Controller
 *
 * @author ruoyi
 * @date 2020-04-14
 */
@Api(tags = "代理人管理")
@RestController
@RequestMapping("/org/dlr")
public class OrgDlrController extends BaseController
{
    @Autowired
    private ITOrgInfoService tOrgInfoService;

    /**
     * 查询部门列表
     */
    @ApiOperation(value = "代理人机构审核")
    @PreAuthorize("@ss.hasPermi('dlrorg:check:index')")
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
    @PreAuthorize("@ss.hasPermi('dlrorg:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOrgInfo tOrgInfo)
    {
        startPage();
        tOrgInfo.setDeptType("01");
        List<TOrgInfo> list = tOrgInfoService.selectTOrgInfoList(tOrgInfo);
        return getDataTable(list);
    }

    /**
     * 导出部门列表
     */
    @PreAuthorize("@ss.hasPermi('dlrorg:info:export')")
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
    @PreAuthorize("@ss.hasPermi('dlrorg:info:query')")
//    @PreAuthorize("hasAnyAuthority('dlrorg:info:query','dlrorg:check:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(tOrgInfoService.selectTOrgInfoById(deptId));
    }

    /**
     * 新增部门
     */
    @PreAuthorize("@ss.hasPermi('dlrorg:info:add')")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOrgInfo tOrgInfo)
    {
        tOrgInfo.setParentId(100L);
        tOrgInfo.setDeptType("01");
        return toAjax(tOrgInfoService.insertTOrgInfo(tOrgInfo));
    }

    /**
     * 修改部门
     */
    @PreAuthorize("@ss.hasPermi('dlrorg:info:edit')")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOrgInfo tOrgInfo)
    {
        return toAjax(tOrgInfoService.updateTOrgInfo(tOrgInfo));
    }

    /**
     * 删除部门
     */
    @PreAuthorize("@ss.hasPermi('dlrorg:info:remove')")
    @Log(title = "部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(tOrgInfoService.deleteTOrgInfoByIds(deptIds));
    }
}
