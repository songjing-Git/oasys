package com.songjing.oasys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Performance;

import java.util.List;
import java.util.Map;

/**
 * (Performance)表服务接口
 *
 * @author songjing
 * @since 2021-04-15 09:43:15
 */
public interface PerformanceService extends IService<Performance> {

    /**
     * 绩效排行
     * @return
     */
    List<Map<String,Object>> selectPerformanceList();
}
