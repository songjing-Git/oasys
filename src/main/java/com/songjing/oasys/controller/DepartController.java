package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Depart;
import com.songjing.oasys.service.DepartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 部门表(Depart)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:10:45
 */
@RestController
@RequestMapping("/depart")
@Api("部门信息接口")
public class DepartController extends ApiController {


    @Resource
    DepartService departService;

    @ApiOperation("通过部门编号查询部门信息")
    @GetMapping("/selectById/{id}")
    public Depart selectById(@PathVariable int id){
       return   departService.getById(id);
    }

    @ApiOperation("查询部门所有信息")
    @GetMapping("/selectDepartInfo")
    public IPage<Depart> selectDepartInfo(@RequestParam(required = false) Map<String,Object> param) {
        return departService.selectDepartInfo(param);
    }

    @ApiOperation("新增部门")
    @PostMapping("/insertDepart")
    public int insertDepart(@RequestBody Depart depart) {
        return departService.insertDepart(depart);
    }

    @ApiOperation("通过部门id删除部门")
    @DeleteMapping("/removeDepart/{id}")
    public boolean removeDepart(@PathVariable int id) {
        return departService.removeById(id);
    }
    
    @ApiOperation("获取所有部门名称")
    @GetMapping("/selectDepartName")
    public List<Map<String ,Object>> selectDepartName() {
        return departService.selectDepartName();
    }

}
