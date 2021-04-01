package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Salary)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:27
 */
@Mapper
@Repository
public interface SalaryMapper extends BaseMapper<Salary> {


}
