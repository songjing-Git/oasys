package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Role;
import com.songjing.oasys.entity.UserRole;
import com.songjing.oasys.mapper.RoleMapper;
import com.songjing.oasys.mapper.UserRoleMapper;
import com.songjing.oasys.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (UserRole)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:17:56
 */
@Service
@Slf4j
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {


    @Resource
    UserRoleMapper userRoleMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> selectStaffRole(String staffId) {
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq(null!=staffId&&!"".equals(staffId),"user_id",staffId);
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);
        List<Integer> roleIdList=new ArrayList<>();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        for (UserRole userRole : userRoles) {
            roleIdList.add(userRole.getRoleId());
        }
        roleQueryWrapper.in("role_id",roleIdList);
        List<Role> roles = roleMapper.selectList(roleQueryWrapper);
        return roles;
    }

    @Override
    public List<Role> selectStaffNoRole(String staffId) {
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq(null!=staffId&&!"".equals(staffId),"user_id",staffId);
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);
        List<Integer> roleIdList=new ArrayList<>();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        for (UserRole userRole : userRoles) {
            roleIdList.add(userRole.getRoleId());
        }
        roleQueryWrapper.notIn("role_id",roleIdList);
        return roleMapper.selectList(roleQueryWrapper);
    }

    @Override
    public List<Role> selectAllRole() {
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int updateStaffRole(Map<String, Object> targetKeys) {

        String staffId = targetKeys.get("staffId").toString();
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.in("user_id",staffId);
        userRoleMapper.delete(userRoleQueryWrapper);
        ArrayList<Integer> targetKey = new ArrayList<>();
        targetKey=(ArrayList)targetKeys.get("targetKeys");
        for (Integer roleId : targetKey) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(Integer.parseInt(staffId));
            userRoleMapper.insert(userRole);
        }

        return targetKey.size();
    }
}
