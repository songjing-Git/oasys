package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (UserRole)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:56
 */
@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
