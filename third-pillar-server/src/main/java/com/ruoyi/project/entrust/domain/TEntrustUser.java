package com.ruoyi.project.entrust.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 委托人对象 t_entrust_user
 *
 * @author tjs
 * @date 2020-04-19
 */
public class TEntrustUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 委托人名称 */
    @Excel(name = "委托人名称")
    private String userName;

    /** 养老计划名称 */
    @Excel(name = "养老计划名称")
    private String planName;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String cardType;

    /** 证件号 */
    @Excel(name = "证件号")
    private String cardNo;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthday;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String mobileNo;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String contactAddr;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setPlanName(String planName)
    {
        this.planName = planName;
    }

    public String getPlanName()
    {
        return planName;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getCardType()
    {
        return cardType;
    }
    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getCardNo()
    {
        return cardNo;
    }
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    public void setMobileNo(String mobileNo)
    {
        this.mobileNo = mobileNo;
    }

    public String getMobileNo()
    {
        return mobileNo;
    }
    public void setContactAddr(String contactAddr)
    {
        this.contactAddr = contactAddr;
    }

    public String getContactAddr()
    {
        return contactAddr;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("planName", getPlanName())
            .append("name", getName())
            .append("gender", getGender())
            .append("nation", getNation())
            .append("cardType", getCardType())
            .append("cardNo", getCardNo())
            .append("birthday", getBirthday())
            .append("mobileNo", getMobileNo())
            .append("contactAddr", getContactAddr())
            .append("email", getEmail())
            .append("remarks", getRemarks())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
