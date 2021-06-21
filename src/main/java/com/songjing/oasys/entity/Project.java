package com.songjing.oasys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * (Project)表实体类
 *
 * @author songjing
 * @since 2021-04-19 14:47:54
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("project")
public class Project implements Serializable {

    /**
     * 项目编码
     */
    @TableField("project_id")
    private Integer projectId;

    /**
     * 项目名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 项目类型
     */
    @TableField("project_type")
    private String projectType;

    /**
     * 甲方
     */
    @TableField("first_party")
    private String firstParty;

    /**
     * 项目状态
     */
    @TableField("projectState")
    private String projectstate;

    /**
     * 项目开始时间
     */
    @TableField("project_start_date")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date projectStartDate;

    /**
     * 预计完工日期
     */
    @TableField("project_end_date")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date projectEndDate;

    /**
     * 预计交付日期
     */
    @TableField("pay_date")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date payDate;

    /**
     * 项目投入人数
     */
    @TableField("project_people_number")
    private Integer projectPeopleNumber;

    /**
     * 交易金额
     */
    @TableField("amount")
    private Long amount;

    /**
     * 甲方预付定金
     */
    @TableField("advance_money")
    private Long advanceMoney;

    /**
     * 甲方应付尾款
     */
    @TableField("fine_money")
    private Long fineMoney;

    /**
     * 实付
     */
    @TableField("real_money")
    private Long realMoney;

    /**
     * 甲方联系人
     */
    @TableField("contact_person")
    private String contactPerson;

    /**
     * 甲方联系人电话
     */
    @TableField("contact_phone")
    private Long contactPhone;

    /**
     * 项目申请人
     */
    @TableField("project_app_person")
    private String projectAppPerson;

    /**
     * 项目申请人编号
     */
    @TableField("project_app_person_code")
    private Integer projectAppPersonCode;

    /**
     * 项目负责人/项目领导者
     */
    @TableField("leading_person")
    private String leadingPerson;

    /**
     * 项目申请日期
     */
    @TableField("apply_date")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date applyDate;

    /**
     * 审核人1
     */
    @TableField("assessor1")
    private String assessor1;

    /**
     * 审核人2
     */
    @TableField("assessor2")
    private String assessor2;

    /**
     * 审核人3
     */
    @TableField("assessor3")
    private String assessor3;
}
