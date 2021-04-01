package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (MenuRole)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:16:39
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu_role")
public class MenuRole implements Serializable {

    @TableField("menu_role_id")
    private Integer menuRoleId;

    @TableField("menu_id")
    private Integer menuId;

    @TableField("role_id")
    private Integer roleId;
}
