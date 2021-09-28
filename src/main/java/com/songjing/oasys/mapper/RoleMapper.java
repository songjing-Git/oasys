package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    /**
     * 通过roleId获取角色信息
     *
     * @param roleId
     * @return
     */
    @Select("select role_type from role where role_id = #{roleId}")
    Role getRoleById(int roleId);
}
