package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Performance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (Performance)表服务接口
 *
 * @author songjing
 * @since 2021-04-15 09:43:15
 */
@Mapper
@Repository
public interface PerformanceMapper extends BaseMapper<Performance> {

    /**
     * 绩效排行查询
     * @return
     */
    @Select("select * from performance where 1=1 order by Performance_score desc limit 10")
    List<Map<String,Object>> selectPerformanceList();

}
