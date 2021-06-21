package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Role;
import com.songjing.oasys.mapper.RoleMapper;
import com.songjing.oasys.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:17:07
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public List<String> selectRoleName() {
        List<Role> roles = roleMapper.selectList(null);
        List<String> roleNameList = new ArrayList<>();
        for (Role role : roles) {
            roleNameList.add(role.getRoleName());
        }
        return roleNameList;
    }
}
