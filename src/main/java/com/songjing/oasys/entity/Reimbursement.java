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
 * (Reimbursement)表实体类
 *
 * @author songjing
 * @since 2021-04-18 14:34:14
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("reimbursement")
public class Reimbursement implements Serializable {

    /**
     * 报销id
     */
    @TableField("rmb_id")
    private Integer rmbId;

    /**
     * 报销类型
     */
    @TableField("rmb_type")
    private String rmbType;

    /**
     * 报销员工id
     */
    @TableField("rmb_staff_id")
    private String rmbStaffId;

    /**
     * 报销员工名称
     */
    @TableField("rmb_staff_name")
    private String rmbStaffName;

    /**
     * 报销中心
     */
    @TableField("rmb_center")
    private String rmbCenter;

    /**
     * 项目id
     */
    @TableField("rmb_pro_id")
    private String rmbProId;

    /**
     * 金额
     */
    @TableField("rmb_nubmer")
    private Object rmbNubmer;

    /**
     * 报销时间
     */
    @TableField("rmb_real_date")
    private Date rmbRealDate;

    /**
     * 填写时间
     */
    @TableField("fill_date")
    private Date fillDate;

    /**
     * 发票编码
     */
    @TableField("invoice_code")
    private Long invoiceCode;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
}
