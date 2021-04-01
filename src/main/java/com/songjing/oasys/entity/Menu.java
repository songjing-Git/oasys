package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Menu)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:16:26
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu")
public class Menu implements Serializable {

    @TableField("menu_id")
    private Integer menuId;

    /**
     * 路径匹配规则
     */
    @TableField("url")
    private String url;

    @TableField("path")
    private String path;

    @TableField("name")
    private String name;

    @TableField("title")
    private String title;

    @TableField("Icon")
    private String icon;

    @TableField("requireAuth")
    private String requireauth;

    @TableField("keepAlive")
    private String keepalive;

    @TableField("hideInMenu")
    private Boolean hideinmenu;

    @TableField("component")
    private String component;

    @TableField("parent_menu_id")
    private Integer parentMenuId;
}
