package com.songjing.oasys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Salary;

import java.util.Map;

/**
 * (Salary)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:27
 */
public interface SalaryService extends IService<Salary> {

    /**
     * 薪资查询
     *
     * @param param
     * @return
     */
    IPage<Salary> querySalary(Map<String, Object> param);
}
