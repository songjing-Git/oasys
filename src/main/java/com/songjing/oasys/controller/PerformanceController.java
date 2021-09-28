package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.service.PerformanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Performance)表控制层
 *
 * @author songjing
 * @since 2021-04-15 09:43:15
 */
@RestController
@RequestMapping("performance")
@Api("绩效接口")
public class PerformanceController extends ApiController {

    @Resource
    PerformanceService performanceService;

    @ApiOperation("绩效排行")
    @GetMapping("/performanceList")
    public List<Map<String, Object>> queryPerformanceList() {
        return performanceService.selectPerformanceList();
    }

}
