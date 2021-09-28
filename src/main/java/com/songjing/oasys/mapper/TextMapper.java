package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Text;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * (Text)表服务接口
 *
 * @author songjing
 * @since 2021-04-16 14:49:13
 */
@Mapper
@Repository
public interface TextMapper extends BaseMapper<Text> {

    /**
     * @param textType
     * @param date
     * @return
     */
    @Select("select * from text where text_type=#{textType} and text_valid_date<=#{date} and text_expire_date>=#{date}")
    Text policyPush(@Param("textType") String textType, @Param("date") String date);

}
