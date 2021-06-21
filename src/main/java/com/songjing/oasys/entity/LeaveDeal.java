package com.songjing.oasys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * (LeaveDeal)表实体类
 *
 * @author songjing
 * @since 2021-05-19 14:59:36
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("leave_deal")
public class LeaveDeal implements Serializable {

    /**
     * 离职id
     */
    @TableField("leave_id")
    private Integer leaveId;

    /**
     * 离职员工id
     */
    @TableField("leave_staff_id")
    private Integer leaveStaffId;

    /**
     * 离职填报类型
     */
    @TableField("leave_fill_type")
    private Integer leaveFillType;

    /**
     * 代理填报员工
     */
    @TableField("policy_fill_staff")
    private Integer policyFillStaff;

    /**
     * 离职员工名称
     */
    @TableField("leave_staff_name")
    private String leaveStaffName;

    /**
     * 离职员工职位等级
     */
    @TableField("leave_staff_job_level")
    private String leaveStaffJobLevel;

    /**
     * 离职员工电话
     */
    @TableField("leave_staff_phone")
    private String leaveStaffPhone;

    /**
     * 建议
     */
    @TableField("proposal")
    private String proposal;

    /**
     * 评分
     */
    @TableField("score")
    private Double score;

    /**
     * 离职原因
     */
    @TableField("leave_reason")
    private String leaveReason;

    /**
     * 离职日期
     */
    @TableField("leave_date")
    private Date leaveDate;
}
