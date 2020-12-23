package com.songjing.oasys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjing3@asiainfo
 * @version 1.0
 * @date 2020/12/22 15:49
 */
@Api("用户信息")
@RestController
public class UserController {

    @ApiOperation("用户登录信息查询")
    @GetMapping("/login")
    public String userLogin(String username,String password){
        return username+password;
    }
}
