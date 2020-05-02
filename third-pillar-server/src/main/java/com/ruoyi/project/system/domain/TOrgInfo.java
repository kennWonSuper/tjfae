package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 部门对象 t_org_info
 *
 * @author ruoyi
 * @date 2020-04-14
 */
public class TOrgInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机构id */
    private Long deptId;

    /** 父机构id */
    @Excel(name = "父机构id")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private String deptName;

    /** 机构类型 01-代理人机构;02-清分机构;03-受托人机构;04-账管人机构;05-存管人机构;06-投管人机构 */
    @Excel(name = "机构类型 01-代理人机构;02-清分机构;03-受托人机构;04-账管人机构;05-存管人机构;06-投管人机构")
    private String deptType;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String leader;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 机构状态（0正常 1停用） */
    @Excel(name = "机构状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 社会信用代码 */
    @Excel(name = "社会信用代码")
    private String socialCreditCode;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String corporate;

    /** 注册地址 */
    @Excel(name = "注册地址")
    private String registerAddress;

    /** 注册资金(万元) */
    @Excel(name = "注册资金(万元)")
    private Double registerAmount;

    /** 清分机构名称 */
    @Excel(name = "清分机构名称")
    private String clearingDeptName;

    /** 开户行名称 */
    @Excel(name = "开户行名称")
    private String bankName;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String accountName;

    /** 银行账号 */
    @Excel(name = "银行账号")
    private String accountNo;

    /** 备注 */
    @Excel(name = "备注")
    private String bake;

    private String checkStatus;

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    public String getAncestors()
    {
        return ancestors;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setDeptType(String deptType)
    {
        this.deptType = deptType;
    }

    public String getDeptType()
    {
        return deptType;
    }
    public void setOrderNum(Integer orderNum)
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum()
    {
        return orderNum;
    }
    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    public String getLeader()
    {
        return leader;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setSocialCreditCode(String socialCreditCode)
    {
        this.socialCreditCode = socialCreditCode;
    }

    public String getSocialCreditCode()
    {
        return socialCreditCode;
    }
    public void setCorporate(String corporate)
    {
        this.corporate = corporate;
    }

    public String getCorporate()
    {
        return corporate;
    }
    public void setRegisterAddress(String registerAddress)
    {
        this.registerAddress = registerAddress;
    }

    public String getRegisterAddress()
    {
        return registerAddress;
    }
    public void setRegisterAmount(Double registerAmount)
    {
        this.registerAmount = registerAmount;
    }

    public Double getRegisterAmount()
    {
        return registerAmount;
    }
    public void setClearingDeptName(String clearingDeptName)
    {
        this.clearingDeptName = clearingDeptName;
    }

    public String getClearingDeptName()
    {
        return clearingDeptName;
    }
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }

    public String getBankName()
    {
        return bankName;
    }
    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public String getAccountName()
    {
        return accountName;
    }
    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }

    public String getAccountNo()
    {
        return accountNo;
    }
    public void setBake(String bake)
    {
        this.bake = bake;
    }

    public String getBake()
    {
        return bake;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("deptName", getDeptName())
            .append("deptType", getDeptType())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("socialCreditCode", getSocialCreditCode())
            .append("corporate", getCorporate())
            .append("registerAddress", getRegisterAddress())
            .append("registerAmount", getRegisterAmount())
            .append("clearingDeptName", getClearingDeptName())
            .append("bankName", getBankName())
            .append("accountName", getAccountName())
            .append("accountNo", getAccountNo())
            .append("bake", getBake())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
