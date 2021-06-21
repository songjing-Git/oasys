package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.LeaveDeal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (LeaveDeal)表服务接口
 *
 * @author songjing
 * @since 2021-05-19 14:59:36
 */
@Mapper
@Repository
public interface LeaveDealMapper extends BaseMapper<LeaveDeal> {

}
