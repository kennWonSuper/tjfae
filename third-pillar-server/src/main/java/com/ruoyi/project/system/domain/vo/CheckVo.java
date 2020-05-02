package com.ruoyi.project.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 路由显示信息
 *
 * @author tjs
 */
public class CheckVo
{
    @ApiModelProperty(value = "机构id", name = "deptId")
    private Long deptId;

    @ApiModelProperty(value = "审核是否通过 1-是 0-否", name = "isPass")
    private Integer isPass;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }
}
