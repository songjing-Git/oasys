package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Project;
import com.songjing.oasys.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class ProjectController extends ApiController {

    @Resource
    ProjectService projectService;

    @ApiOperation("项目信息查询")
    @GetMapping("/queryProjectInfo")
    public IPage queryProjectInfo(@RequestParam(required = false) Map<String,String> param) {
        log.info("param:"+param);
        return projectService.queryProjectInfo(param);
    }


    @ApiOperation("新增项目")
    @PostMapping("/insertProject")
    public boolean insertProject(@RequestBody Project project){
        log.info("========> project:"+project);
        project.setProjectstate("1");
        return projectService.save(project);
    }

    @ApiOperation("修改项目")
    @PutMapping("/updateProject")
    public boolean updateProject(@RequestBody Project project){
        log.info("========> project:"+project);
        QueryWrapper<Project> projectQueryWrapper = new QueryWrapper<Project>();
        projectQueryWrapper.eq("project_id",project.getProjectId());
        return projectService.update(project,projectQueryWrapper);
    }
}
