package com.songjing.oasys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Role;
import com.songjing.oasys.entity.UserRole;

import java.util.List;
import java.util.Map;

/**
 * (UserRole)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:56
 */
public interface UserRoleService extends IService<UserRole> {


    /**
     * 根据员工编号查询员工角色信息
     *
     * @param staffId
     * @return
     */
    List<Role> selectStaffRole(String staffId);

    /**
     * 根据员工编号查询员工没有角色信息
     *
     * @param staffId
     * @return
     */
    List<Role> selectStaffNoRole(String staffId);

    /**
     * 获取员工所有权限
     *
     * @return
     */
    List<Role> selectAllRole();


    /**
     * 更新员工权限信息
     *
     * @param targetKeys
     * @return
     */
    int updateStaffRole(Map<String, Object> targetKeys);
}
