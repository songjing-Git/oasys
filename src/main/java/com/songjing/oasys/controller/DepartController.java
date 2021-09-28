package com.songjing.oasys.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Depart;
import com.songjing.oasys.service.DepartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Slf4j
public class DepartController extends ApiController {


    @Resource
    DepartService departService;

    @ApiOperation("通过部门编号查询部门信息")
    @GetMapping("/selectById/{id}")
    public Depart selectById(@PathVariable int id) {
        return departService.getById(id);
    }

    @ApiOperation("查询部门所有信息")
    @GetMapping("/selectDepartInfo")
    public IPage<Depart> selectDepartInfo(@RequestParam(required = false) Map<String, Object> param) {
        return departService.selectDepartInfo(param);
    }

    @ApiOperation("新增部门")
    @PostMapping("/insertDepart")
    @PreAuthorize("hasAnyRole('root','admin')")
    public int insertDepart(@RequestBody Depart depart) {
        return departService.insertDepart(depart);
    }

    @ApiOperation("通过部门id删除部门")
    @DeleteMapping("/removeDepart/{id}")
    @PreAuthorize("hasAnyRole('root','admin')")
    public int removeDepart(@PathVariable int id) {
        return departService.removeById(id);
    }

    @ApiOperation("获取所有部门名称")
    @GetMapping("/selectDepartName")
    public List<Map<String, Object>> selectDepartName() {
        return departService.selectDepartName();
    }


    @ApiOperation("修改部门信息")
    @PutMapping("/updateDepart")
    public boolean updateDepartInfo(@RequestBody Map<String, Object> param) {
        log.info("=>param:" + param);
        if (param.isEmpty()) {
            throw new RuntimeException("修改部门信息时参数不能为空");
        }
        int departId = Integer.parseInt(param.get("departId").toString());
        Depart depart = JSON.parseObject(JSON.toJSONString(param), Depart.class);
        log.info("=========>Depart:" + depart);
        QueryWrapper<Depart> departQueryWrapper = new QueryWrapper<>();
        departQueryWrapper.eq("depart_id", departId);
        boolean update = departService.update(depart, departQueryWrapper);
        return update;
    }


}
