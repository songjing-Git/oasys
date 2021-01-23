package com.songjing.oasys.staff.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.staff.entity.User;
import com.songjing.oasys.staff.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author songjing
 * @since 2021-01-05 15:23:15
 */
@RestController
@RequestMapping("user")
@Slf4j
@Api(value = "用户信息接口")
public class UserController extends ApiController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户登录接口", notes = "用户登录接口")
    @RequestMapping(value = "/login" ,method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public boolean login(@RequestBody Map<String,String> param){

        String password = param.get("password");
        String username = param.get("username");
        if (username!=null&&"".equals(username)){
            return false;
        }
        List<User> DbUser = userService.list();
        for (User user: DbUser ) {
            log.info("================username:"+username);
            log.info("================user.getUserName():"+user.getUserName());
            log.info("================user.getUserName().equals(username):"+user.getUserName().equals(username));
            if (user.getUserName().equals(username)){
                log.info("================password:"+password);
                log.info("================user.getPassword():"+user.getPassword());
                log.info("================user.getPassword().equals(password):"+user.getPassword().equals(password));
                System.out.println(Arrays.toString(password.getBytes()));
                System.out.println(Arrays.toString(user.getPassword().getBytes()));
                if (user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

}