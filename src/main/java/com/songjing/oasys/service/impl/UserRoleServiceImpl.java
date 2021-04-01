package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.UserRole;
import com.songjing.oasys.mapper.UserRoleMapper;
import com.songjing.oasys.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (UserRole)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:17:56
 */
@Service
@Slf4j
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
