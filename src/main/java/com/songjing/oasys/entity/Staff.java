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
 * (Staff)表实体类
 *
 * @author songjing
 * @since 2021-03-21 15:37:25
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("staff")
public class Staff implements Serializable {

    /**
     * 员工编号
     */
    @TableField("staff_id")
    private Integer staffId;

    /**
     * 名称
     */
    @TableField("staff_name")
    private String staffName;

    /**
     * 用户头像
     */
    @TableField("face")
    private byte[] face;

    /**
     * OA登录账号
     */
    @TableField("user_name")
    private String userName;

    /**
     * OA账号密码
     */
    @TableField("password")
    private String password;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 生日
     */
    @TableField("birthday")
    private Date birthday;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 身份证
     */
    @TableField("id_card")
    private Long idCard;

    /**
     * 婚姻状况
     */
    @TableField("wedlock")
    private String wedlock;

    /**
     * 民族
     */
    @TableField("nation")
    private String nation;

    /**
     * 籍贯
     */
    @TableField("native_place")
    private Integer nativePlace;

    /**
     * 政治面貌
     */
    @TableField("politic")
    private String politic;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 电话号码
     */
    @TableField("phone")
    private Long phone;

    /**
     * 联系地址
     */
    @TableField("address")
    private String address;

    /**
     * 所属部门
     */
    @TableField("depart_id")
    private Integer departId;

    /**
     * 职位等级
     */
    @TableField("job_level_id")
    private Integer jobLevelId;

    /**
     * 工龄
     */
    @TableField("work_age")
    private Integer workAge;

    /**
     * 薪资
     */
    @TableField("salary_id")
    private Integer salaryId;

    /**
     * 最高学历
     */
    @TableField("tip_top_degree")
    private String tipTopDegree;

    /**
     * 所属专业
     */
    @TableField("specialty")
    private String specialty;

    /**
     * 毕业院校
     */
    @TableField("school")
    private String school;

    /**
     * 入职日期
     */
    @TableField("begin_date")
    private Date beginDate;

    /**
     * 在职状态 0-离职， 1在职
     */
    @TableField("work_state")
    private Integer workState;

    /**
     * 合同起始日期
     */
    @TableField("begin_contract")
    private Date beginContract;

    /**
     * 合同终止日期
     */
    @TableField("end_contract")
    private Date endContract;
}
