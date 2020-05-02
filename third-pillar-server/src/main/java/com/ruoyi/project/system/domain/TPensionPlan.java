package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 养老计划对象 t_pension_plan
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
public class TPensionPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 养老计划id */
    private Long planId;

    /** 养老计划名称 */
    @Excel(name = "养老计划名称")
    private String planName;

    /** 养老计划编号 */
    @Excel(name = "养老计划编号")
    private String planNumber;

    /** 计划开始时间 */
    @Excel(name = "计划开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 代理人id */
    @Excel(name = "代理人id")
    private Long agentId;

    /** 清分机构id */
    @Excel(name = "清分机构id")
    private Long clearId;

    /** 受托人id */
    @Excel(name = "受托人id")
    private Long trusteeId;

    /** 存管人id */
    @Excel(name = "存管人id")
    private Long custodianId;

    /** 费用计算周期 */
    @Excel(name = "费用计算周期")
    private String feePeriod;

    /** 受托人管理费率 */
    @Excel(name = "受托人管理费率")
    private Double trusteeRate;

    /** 存管人管理费率 */
    @Excel(name = "存管人管理费率")
    private Double custodianRate;

    /** 备注 */
    @Excel(name = "备注")
    private String bake;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setPlanNumber(String planNumber) 
    {
        this.planNumber = planNumber;
    }

    public String getPlanNumber() 
    {
        return planNumber;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setAgentId(Long agentId) 
    {
        this.agentId = agentId;
    }

    public Long getAgentId() 
    {
        return agentId;
    }
    public void setClearId(Long clearId) 
    {
        this.clearId = clearId;
    }

    public Long getClearId() 
    {
        return clearId;
    }
    public void setTrusteeId(Long trusteeId) 
    {
        this.trusteeId = trusteeId;
    }

    public Long getTrusteeId() 
    {
        return trusteeId;
    }
    public void setCustodianId(Long custodianId) 
    {
        this.custodianId = custodianId;
    }

    public Long getCustodianId() 
    {
        return custodianId;
    }
    public void setFeePeriod(String feePeriod) 
    {
        this.feePeriod = feePeriod;
    }

    public String getFeePeriod() 
    {
        return feePeriod;
    }
    public void setTrusteeRate(Double trusteeRate) 
    {
        this.trusteeRate = trusteeRate;
    }

    public Double getTrusteeRate() 
    {
        return trusteeRate;
    }
    public void setCustodianRate(Double custodianRate) 
    {
        this.custodianRate = custodianRate;
    }

    public Double getCustodianRate() 
    {
        return custodianRate;
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
            .append("planId", getPlanId())
            .append("planName", getPlanName())
            .append("planNumber", getPlanNumber())
            .append("startTime", getStartTime())
            .append("agentId", getAgentId())
            .append("clearId", getClearId())
            .append("trusteeId", getTrusteeId())
            .append("custodianId", getCustodianId())
            .append("feePeriod", getFeePeriod())
            .append("trusteeRate", getTrusteeRate())
            .append("custodianRate", getCustodianRate())
            .append("bake", getBake())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
