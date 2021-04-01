package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门表(Depart)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:10:43
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("depart")
public class Depart implements Serializable {

    /**
     * 部门编号
     */
    @TableField("depart_id")
    private Integer departId;

    /**
     * 部门名称
     */
    @TableField("depart_name")
    private String departName;

    /**
     * 部门经理
     */
    @TableField("depart_mgr")
    private String departMgr;

    /**
     * 部门员工人数
     */
    @TableField("depart_staff_count")
    private Integer departStaffCount;

    /**
     * 允许员工人数上限
     */
    @TableField("depart_staff_max")
    private Integer departStaffMax;
}
