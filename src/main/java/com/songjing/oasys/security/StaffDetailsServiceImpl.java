package com.songjing.oasys.security;

import com.songjing.oasys.entity.Role;
import com.songjing.oasys.entity.Staff;
import com.songjing.oasys.entity.UserRole;
import com.songjing.oasys.mapper.RoleMapper;
import com.songjing.oasys.mapper.StaffMapper;
import com.songjing.oasys.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/4/28 15:00
 */


@Service(value = "userDetailsService")
@Slf4j
public class StaffDetailsServiceImpl implements UserDetailsService {

    @Resource
    private StaffMapper staffMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RoleMapper roleMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("============userName:" + userName);
        if (userName == null || userName.length() == 0) {
            throw new RuntimeException("用户名不能为空");
        }
        Staff staff = staffMapper.loadUserByUsername(userName);
        if (staff == null) {
            throw new InternalAuthenticationServiceException("根据用户名未找到用户信息");
        }
        List<UserRole> roleByStaffId = userRoleMapper.getRoleByUserName(staff.getStaffId());
        log.info("=============:roleByStaffId" + roleByStaffId);
        List<Role> roles = new ArrayList<>();
        for (UserRole uRole : roleByStaffId) {
            Role roleById = roleMapper.getRoleById(uRole.getRoleId());
            log.info("===================roleById:" + roleById);
            roles.add(roleById);

        }
        staff.setRoles(roles);
        log.info("==========>  staff:" + staff);
        log.info("==========>  staff:" + staff.getAuthorities());
        /*List<GrantedAuthority> authorities=new ArrayList<>();
        //获取员工的角色权限信息
        List<UserRole> roleByStaffId = userRoleMapper.getRoleByUserName(staff.getStaffId());
        for (UserRole uRole:roleByStaffId) {
            Role role = roleMapper.getRoleById(uRole.getRoleId());
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleType());
            authorities.add(simpleGrantedAuthority);
        }*/
        return staff;
    }
}
