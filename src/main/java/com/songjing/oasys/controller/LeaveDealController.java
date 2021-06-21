package com.songjing.oasys.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.LeaveDeal;
import com.songjing.oasys.service.LeaveDealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (LeaveDeal)表控制层
 *
 * @author songjing
 * @since 2021-05-19 14:59:36
 */
@RestController
@RequestMapping("leaveDeal")
@Api
@Slf4j
public class LeaveDealController extends ApiController {


    @Resource
    LeaveDealService leaveDealService;

    @ApiOperation("离职处理")
    @PostMapping("/leaveDeal")
    public int leaveDeal(@RequestBody Map<String ,Object> param){
        log.info("=========> {param}"+param);
        LeaveDeal leaveDeal = JSON.parseObject(JSON.toJSONString(param), LeaveDeal.class);
        return leaveDealService.insertLeaveDealInfo(param);
    }
}
