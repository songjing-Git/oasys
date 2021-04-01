package com.songjing.oasys.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (JobLevel)表实体类
 *
 * @author songjing
 * @since 2021-03-16 15:10:45
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("job_level")
public class JobLevel implements Serializable {

    /**
     * 职位等级编号
     */
    @TableField("JOB_LEVEL_ID")
    private Integer jobLevelId;

    /**
     * 职位等级类型
     */
    @TableField("JOB_LEVEL_TYPE")
    private String jobLevelType;

    @TableField("JOB_LEVEL")
    private String jobLevel;

    /**
     * 职位等级名称
     */
    @TableField("JOB_LEVEL_NAME")
    private String jobLevelName;
}
