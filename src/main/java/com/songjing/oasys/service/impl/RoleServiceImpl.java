package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Role;
import com.songjing.oasys.mapper.RoleMapper;
import com.songjing.oasys.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (Role)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:17:07
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
