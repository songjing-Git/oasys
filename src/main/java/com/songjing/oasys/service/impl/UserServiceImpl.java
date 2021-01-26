package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.User;
import com.songjing.oasys.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<com.songjing.oasys.mapper.UserMapper, User> implements UserService {

}