package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Salary)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:17:27
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("salary")
public class Salary implements Serializable {

    /**
     * 薪资编号
     */
    @TableField("salary_id")
    private Integer salaryId;

    /**
     * 基础薪资
     */
    @TableField("base_salary")
    private Integer baseSalary;

    /**
     * 岗位工资
     */
    @TableField("post_wage")
    private Integer postWage;

    /**
     * 绩效工资
     */
    @TableField("merit_money")
    private Integer meritMoney;

    /**
     * 应发薪资
     */
    @TableField("pay_salary")
    private Integer paySalary;

    /**
     * 全勤奖
     */
    @TableField("full_prize")
    private Integer fullPrize;

    /**
     * 加班费
     */
    @TableField("overtime_money")
    private Integer overtimeMoney;

    /**
     * 养老保险
     */
    @TableField("endowment_ins")
    private Object endowmentIns;

    /**
     * 医疗保险
     */
    @TableField("medical_ins")
    private Object medicalIns;

    /**
     * 失业保险
     */
    @TableField("unemp_ins")
    private Object unempIns;

    /**
     * 工伤保险
     */
    @TableField("work_injury_ins")
    private Object workInjuryIns;

    /**
     * 生育保险
     */
    @TableField("birth_ins")
    private Object birthIns;

    /**
     * 住房公积金
     */
    @TableField("housing_provident_fund")
    private Object housingProvidentFund;

    /**
     * 个人所得税
     */
    @TableField("personal_income_tax")
    private Object personalIncomeTax;

    /**
     * 扣发工资
     */
    @TableField("deduct_wages")
    private Object deductWages;

    /**
     * 实发工资
     */
    @TableField("real_wages")
    private Object realWages;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
}
