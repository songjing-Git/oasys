package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Performance;
import com.songjing.oasys.mapper.PerformanceMapper;
import com.songjing.oasys.mapper.StaffMapper;
import com.songjing.oasys.service.PerformanceService;
import com.songjing.oasys.service.StaffService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Performance)表服务实现类
 *
 * @author songjing
 * @since 2021-04-15 09:43:15
 */
@Service
@Slf4j
public class PerformanceServiceImpl extends ServiceImpl<PerformanceMapper, Performance> implements PerformanceService {


    @Resource
    PerformanceMapper performanceMapper;

    @Resource
    StaffService staffService;

    @Resource
    StaffMapper staffMapper;


    @Override
    public List<Map<String, Object>> selectPerformanceList() {
        List<Map<String, Object>> performanceList = performanceMapper.selectPerformanceList();
        if (performanceList.isEmpty()){
            return null;
        }
        for (Map<String,Object> performanceMap:performanceList) {
            if (Maps.isNotEmpty(performanceMap,"staff_id")){
                String staffName =
                        staffMapper.selectStaffNameById(Integer.parseInt(performanceMap.get("staff_id").toString()));
                performanceMap.put("staffName",staffName);
            }
        }

        return performanceList;
    }
}
