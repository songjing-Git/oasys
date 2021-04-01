package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.JobLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * (JobLevel)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:10:47
 */
@Mapper
@Repository
public interface JobLevelMapper extends BaseMapper<JobLevel> {

    /**
     * 通过职位名称查询职位Id
     * @param jobLevelName
     * @return
     */
    @Select("select job_level_id from job_level where job_level_name=#{jobLevelName}")
    int selectJobLevelIdByName(String jobLevelName);
}
