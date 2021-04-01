package com.songjing.oasys.pub.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (City)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:12:54
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("city")
public class City implements Serializable {

    @TableField("city_id")
    private Integer cityId;

    @TableField("city_name")
    private String cityName;

    @TableField("province_id")
    private Integer provinceId;
}
