package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Project;
import com.songjing.oasys.mapper.ProjectMapper;
import com.songjing.oasys.service.ProjectService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Project)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:13:30
 */
@Service
@Slf4j
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Resource
    ProjectMapper projectMapper;

    @Override
    public IPage queryProjectInfo(Map<String, String> param) {
        IPage page=new Page();
        if (Maps.isNotEmpty(param,"current")){
            page.setCurrent(Long.parseLong(param.get("current")));
        }
        if (Maps.isNotEmpty(param,"pageSize")){
            page.setCurrent(Long.parseLong(param.get("pageSize")));
        }
        QueryWrapper<Project> projectQueryWrapper=new QueryWrapper<>();
        projectQueryWrapper
                .eq(Maps.isNotEmpty(param,"project_name"),"project_name",param.get("project_name"))
                .eq(Maps.isNotEmpty(param,"project_id"),"project_id",param.get("project_id"))
                .eq(Maps.isNotEmpty(param,"assessor1"),"assessor1",param.get("assessor1"));

        return projectMapper.selectPage(page,projectQueryWrapper);
    }
}
