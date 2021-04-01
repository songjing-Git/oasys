package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Role)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:08
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {

}
