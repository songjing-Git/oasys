package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Work;
import com.songjing.oasys.mapper.WorkMapper;
import com.songjing.oasys.service.WorkService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (Work)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:13:36
 */
@Service
@Slf4j
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {


    @Resource
    WorkMapper workMapper;

    @Override
    public IPage selectWorkInfo(Map<String, Object> param) {
        IPage page = new Page<>();
        if (param.containsKey("current")) {
            page.setCurrent(Long.parseLong(param.get("current").toString()));
        }
        if (param.containsKey("pageSize")) {
            page.setSize(Long.parseLong(param.get("pageSize").toString()));
        }
        QueryWrapper<Work> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Maps.isNotEmpty(param, "work_name"), "work_name", param.get("work_name"))
                .eq(Maps.isNotEmpty(param, "work_addr"), "work_addr", param.get("work_addr"))
                .eq(Maps.isNotEmpty(param, "salary"), "salary", param.get("salary"));
        return workMapper.selectMapsPage(page, queryWrapper);
    }
}
