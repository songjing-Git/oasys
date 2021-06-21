package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Role;
import com.songjing.oasys.service.UserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (UserRole)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:17:56
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController extends ApiController {


    @Resource
    UserRoleService userRoleService;

    @ApiOperation("根据员工编号查询员工权限信息")
    @GetMapping("/selectStaffRole/{staffId}")
    public List<Role> selectStaffRole(@PathVariable String staffId){
        return userRoleService.selectStaffRole(staffId);
    }

    @ApiOperation("根据员工编号查询员工权限信息")
    @GetMapping("/selectStaffNoRole/{staffId}")
    public List<Role> selectStaffNoRole(@PathVariable String staffId){
        return userRoleService.selectStaffNoRole(staffId);
    }

    @ApiOperation("根据员工编号查询员工权限信息")
    @GetMapping("/selectAllRole")
    public List<Role> selectAllRole(){
        return userRoleService.selectAllRole();
    }


    @ApiOperation("更新员工权限")
    @PutMapping("/updateRole")
    public int updateStaffRole(@RequestBody Map<String,Object> targetKeys){
        return userRoleService.updateStaffRole(targetKeys);
    }
}
