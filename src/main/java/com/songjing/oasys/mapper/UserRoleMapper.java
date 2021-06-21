package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserRole)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:56
 */
@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 通过用户名获取员工角色关系
     * @param staffId
     * @return
     */
    @Select("select * from user_role where user_id=#{staffId}")
    List<UserRole> getRoleByUserName(int staffId);

    /**
     * 删除员工所有权限
     * @param staffId
     * @return
     */
    @Delete("delete user_role")
    int removeStaffAllRole(String staffId);
}
