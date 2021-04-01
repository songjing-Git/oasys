package com.songjing.oasys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Project;

import java.util.Map;

/**
 * (Project)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:10:52
 */
public interface ProjectService extends IService<Project> {

    /**
     * 根据条件查询项目信息
     * @param param
     * @return
     */
    IPage queryProjectInfo(Map<String,String> param);
}
