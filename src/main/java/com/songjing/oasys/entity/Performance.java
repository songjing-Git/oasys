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
 * (Performance)表实体类
 *
 * @author songjing
 * @since 2021-04-15 09:43:15
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("performance")
public class Performance implements Serializable {

    /**
     * id
     */
    @TableField("performance_id")
    private Integer performanceId;

    /**
     * 考核日期
     */
    @TableField("performance_start_date")
    private Date performanceStartDate;

    @TableField("performance_end_date")
    private Date performanceEndDate;

    /**
     * 考核分数
     */
    @TableField("Performance_score")
    private Object performanceScore;

    /**
     * 员工
     */
    @TableField("staff_id")
    private Integer staffId;
}
