package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Role)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:17:07
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class Role implements Serializable {

    @TableField("role_id")
    private Integer roleId;

    @TableField("role_type")
    private String roleType;

    @TableField("role_name")
    private String roleName;
}
