package com.songjing.oasys.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.staff.entity.User;
import com.songjing.oasys.staff.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author songjing
 * @since 2021-01-05 15:23:15
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<com.songjing.oasys.staff.mapper.UserMapper, User> implements UserService {

}