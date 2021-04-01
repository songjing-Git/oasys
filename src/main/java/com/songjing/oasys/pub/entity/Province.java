package com.songjing.oasys.pub.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Province)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:16:56
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("province")
public class Province implements Serializable {

    @TableField("province_id")
    private Integer provinceId;

    @TableField("province_name")
    private String provinceName;
}
