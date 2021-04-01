package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Salary;
import com.songjing.oasys.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Salary)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:17:27
 */
@RestController
@RequestMapping("salary")
@Api("薪资查询接口")
public class SalaryController extends ApiController {

    @Resource
    SalaryService salaryService;

    @ApiOperation("薪资查询")
    @GetMapping("/querySalaryInfo")
    public Salary querySalaryInfo(int id){
       return salaryService.getById(id);
    }
}
