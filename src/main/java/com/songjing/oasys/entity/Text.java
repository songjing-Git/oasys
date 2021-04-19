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
 * (Text)表实体类
 *
 * @author songjing
 * @since 2021-04-16 14:49:13
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("text")
public class Text implements Serializable {

    @TableField("text_id")
    private Integer textId;

    @TableField("text_type")
    private String textType;

    @TableField("text_title")
    private String textTitle;

    @TableField("text_author")
    private String textAuthor;

    @TableField("text_valid_date")
    private Date textValidDate;

    @TableField("text_expire_date")
    private Date textExpireDate;

    @TableField("text_context")
    private Object textContext;
}
