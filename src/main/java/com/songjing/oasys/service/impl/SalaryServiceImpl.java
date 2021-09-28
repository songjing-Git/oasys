package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Salary;
import com.songjing.oasys.entity.Staff;
import com.songjing.oasys.mapper.SalaryMapper;
import com.songjing.oasys.mapper.StaffMapper;
import com.songjing.oasys.service.SalaryService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * (Salary)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:17:27
 */
@Service
@Slf4j
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements SalaryService {


    @Resource
    StaffMapper staffMapper;

    @Resource
    SalaryMapper salaryMapper;

    @Override
    public IPage<Salary> querySalary(Map<String, Object> param) {
        IPage page = new Page<>();
        page.setSize(10);
        if (Maps.isEmpty(param, "current")) {
            page.setCurrent(1);
        } else {
            page.setCurrent(Long.parseLong(param.get("current").toString()));
        }
        log.info("===> param:" + param);
        String username = param.get("username").toString();
        QueryWrapper<Staff> queryStaffWrapper = new QueryWrapper<>();
        queryStaffWrapper.eq(!"".equals(username), "user_name", username);
        Staff staff = staffMapper.selectOne(queryStaffWrapper);
        if (staff == null) {
            throw new RuntimeException("未找到该用户");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date salaryDate = null;
        try {
            salaryDate = simpleDateFormat.parse(param.get("salaryDate").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(salaryDate);
        calendar.add(Calendar.MONTH, 1);
        Date time = calendar.getTime();
        log.info("salaryDate:" + salaryDate);
        log.info("time:" + time);
        QueryWrapper<Salary> salaryQueryWrapper = new QueryWrapper<>();
        salaryQueryWrapper.eq("salary_id", staff.getSalaryId())
                .ge("salary_date", salaryDate)
                .le("salary_date", time);
        return salaryMapper.selectMapsPage(page, salaryQueryWrapper);
    }
}
