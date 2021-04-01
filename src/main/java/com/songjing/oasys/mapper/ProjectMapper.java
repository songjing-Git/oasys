package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Project)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:10:53
 */
@Mapper
@Repository
public interface ProjectMapper extends BaseMapper<Project> {

}
