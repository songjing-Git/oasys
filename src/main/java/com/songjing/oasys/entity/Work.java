package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Work)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:11:03
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("work")
public class Work implements Serializable {

    /**
     * 职位编号
     */
    @TableField("work_id")
    private Integer workId;

    /**
     * 职位名称
     */
    @TableField("work_name")
    private String workName;

    /**
     * 工作地址
     */
    @TableField("work_addr")
    private Integer workAddr;

    /**
     * 工作经验
     */
    @TableField("work_year")
    private String workYear;

    /**
     * 薪资
     */
    @TableField("salary")
    private Integer salary;

    /**
     * 工作要求/岗位能力匹配
     */
    @TableField("work_match")
    private Object workMatch;
}
