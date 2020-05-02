package com.ruoyi.project.entrust.controller;

import java.util.ArrayList;
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
import com.ruoyi.project.entrust.domain.TEntrustUser;
import com.ruoyi.project.entrust.service.ITEntrustUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 委托人Controller
 *
 * @author tjs
 * @date 2020-04-19
 */
@RestController
@RequestMapping("/entrust/user")
public class TEntrustUserController extends BaseController
{
    @Autowired
    private ITEntrustUserService tEntrustUserService;

    /**
     * 查询委托人列表
     */
    @PreAuthorize("@ss.hasPermi('entrust:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(TEntrustUser tEntrustUser)
    {
        startPage();
        List<TEntrustUser> list = tEntrustUserService.selectTEntrustUserList(tEntrustUser);
        return getDataTable(list);
    }

    /**
     * 导出委托人列表
     */
    @PreAuthorize("@ss.hasPermi('entrust:user:export')")
    @Log(title = "委托人", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TEntrustUser tEntrustUser)
    {
        List<TEntrustUser> list = tEntrustUserService.selectTEntrustUserList(tEntrustUser);
        ExcelUtil<TEntrustUser> util = new ExcelUtil<TEntrustUser>(TEntrustUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 导出委托人列表
     */
    @Log(title = "委托人批量导入模板", businessType = BusinessType.EXPORT)
    @GetMapping("/export/model")
    public AjaxResult exportModel()
    {
        List<TEntrustUser> list = new ArrayList<>();
        ExcelUtil<TEntrustUser> util = new ExcelUtil<TEntrustUser>(TEntrustUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 获取委托人详细信息
     */
    @PreAuthorize("@ss.hasPermi('entrust:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tEntrustUserService.selectTEntrustUserById(id));
    }

    /**
     * 新增委托人
     */
    @PreAuthorize("@ss.hasPermi('entrust:user:add')")
    @Log(title = "委托人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TEntrustUser tEntrustUser)
    {
        return toAjax(tEntrustUserService.insertTEntrustUser(tEntrustUser));
    }

    /**
     * 修改委托人
     */
    @PreAuthorize("@ss.hasPermi('entrust:user:edit')")
    @Log(title = "委托人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TEntrustUser tEntrustUser)
    {
        return toAjax(tEntrustUserService.updateTEntrustUser(tEntrustUser));
    }

    /**
     * 删除委托人
     */
    @PreAuthorize("@ss.hasPermi('entrust:user:remove')")
    @Log(title = "委托人", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tEntrustUserService.deleteTEntrustUserByIds(ids));
    }
}
