package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Work;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Work)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:11:04
 */
@Mapper
@Repository
public interface WorkMapper extends BaseMapper<Work> {

}
