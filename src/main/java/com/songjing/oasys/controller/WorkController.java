package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.service.WorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Work)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:11:04
 */
@RestController
@RequestMapping("work")
@Api
public class WorkController extends ApiController {

    @Resource
    WorkService workService;

    @ApiOperation("查询内推职位信息")
    @GetMapping("/selectWorkInfo")
    public IPage selectWorkInfo(@RequestParam(required = false) Map<String,Object> param) {
        return workService.selectWorkInfo(param);
    }
}
