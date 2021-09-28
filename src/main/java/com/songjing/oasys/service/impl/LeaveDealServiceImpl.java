package com.songjing.oasys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.LeaveDeal;
import com.songjing.oasys.entity.Staff;
import com.songjing.oasys.mapper.LeaveDealMapper;
import com.songjing.oasys.mapper.StaffMapper;
import com.songjing.oasys.service.LeaveDealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (LeaveDeal)表服务实现类
 *
 * @author songjing
 * @since 2021-05-19 14:59:36
 */
@Service
@Slf4j
public class LeaveDealServiceImpl extends ServiceImpl<LeaveDealMapper, LeaveDeal> implements LeaveDealService {


    @Resource
    LeaveDealMapper leaveDealMapper;

    @Resource
    StaffMapper staffMapper;

    @Override
    public int insertLeaveDealInfo(Map<String, Object> param) {
        log.info("=========> {param}" + param);
        if (!"".equals(param.get("leaveStaffId").toString())) {
            QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("staff_id", Integer.parseInt(param.get("leaveStaffId").toString()));
            Staff staff = new Staff();
            staff.setWorkState(0);
            int update = staffMapper.update(staff, queryWrapper);
            log.info("===> update:" + update);
        }
        LeaveDeal leaveDeal = JSON.parseObject(JSON.toJSONString(param), LeaveDeal.class);

        return leaveDealMapper.insert(leaveDeal);
    }
}
