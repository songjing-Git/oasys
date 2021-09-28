package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:17:08
 */
@RestController
@RequestMapping("role")
@Api
public class RoleController extends ApiController {

    @Resource
    RoleService roleService;

    @ApiOperation("查询所有角色名称")
    @GetMapping("/selectRoleName")
    public List<String> selectRoleName() {
        return roleService.selectRoleName();
    }
}
