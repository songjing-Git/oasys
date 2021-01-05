package com.songjing.oasys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author songjing
 * @since 2021-01-05 15:23:13
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {

    /**
     * 员工编号
     */
    @TableField("STAFF_ID")
    private String staffId;

    /**
     * 名称
     */
    @TableField("STAFF_NAME")
    private String staffName;

    /**
     * 登录账号
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 登录密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 性别
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    private String birthday;

    /**
     * 身份证
     */
    @TableField("ID_CARD")
    private String idCard;

    /**
     * 婚姻状况  0-未婚，1-已婚，2-离异，3-丧偶
     */
    @TableField("WEDLOCK")
    private String wedlock;

    /**
     * 民族
     */
    @TableField("NATION")
    private String nation;

    /**
     * 籍贯
     */
    @TableField("NATIVE_PLACE")
    private String nativePlace;

    /**
     * 政治面貌
     */
    @TableField("POLITIC_ID")
    private String politicId;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 电话号码
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 联系地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 所属部门
     */
    @TableField("DEPT_ID")
    private String deptId;

    /**
     * 职位等级
     */
    @TableField("JOB_LEVEL_ID")
    private String jobLevelId;

    /**
     * 最高学历
     */
    @TableField("TIP_TOP_DEGREE")
    private String tipTopDegree;

    /**
     * 所属专业
     */
    @TableField("SPECIALTY")
    private String specialty;

    /**
     * 毕业院校
     */
    @TableField("SCHOOL")
    private String school;

    /**
     * 入职日期
     */
    @TableField("BEGIN_DATE")
    private String beginDate;

    /**
     * 在职状态 0-离职， 1在职
     */
    @TableField("WORK_STATE")
    private String workState;

    /**
     * 合同起始日期
     */
    @TableField("begin_contract")
    private String beginContract;

    /**
     * 合同终止日期
     */
    @TableField("end_contract")
    private String endContract;

    /**
     * 工龄
     */
    @TableField("work_age")
    private String workAge;
}