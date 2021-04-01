package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Project)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:10:53
 */
@RestController
@RequestMapping("project")
@Api("项目信息接口")
public class ProjectController extends ApiController {

    @Resource
    ProjectService projectService;

    @ApiOperation("项目信息查询")
    @GetMapping("/queryProjectInfo")
    public IPage queryProjectInfo(@RequestParam(required = false) Map<String,String> param) {
        return projectService.queryProjectInfo(param);
    }
}
