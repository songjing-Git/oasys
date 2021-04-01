package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Staff)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:15:49
 */
@RestController
@RequestMapping("staff")
@Api("用户信息接口")
@Slf4j
public class StaffController extends ApiController {

    @Resource
    StaffService staffService;

    @ApiOperation("查询所有员工信息")
    @GetMapping("/queryStaffInfo")
    public IPage queryStaffInfo(@RequestParam(required = false) Map<String,Object> param) {
        log.info("==========param:"+param);
        return staffService.queryStaffInfo(param);
    }

    @ApiOperation("根据名称查询员工信息")
    @GetMapping("/selectStaffInfoByName/{username}")
    public Map<String,Object> selectStaffInfoByName(@PathVariable String username) {
        return staffService.selectStaffInfoByName(username);
    }

    @ApiOperation("新增员工")
    @PostMapping("/insertStaff")
    public int insertStaff(@RequestBody Map<String,Object> staffInfo) {
        return staffService.insertStaff(staffInfo);
    }

}
