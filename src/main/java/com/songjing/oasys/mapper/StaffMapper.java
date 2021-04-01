package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.songjing.oasys.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * (Staff)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:15:49
 */
@Mapper
@Repository
public interface StaffMapper extends BaseMapper<Staff> {

    IPage<Map<String,Object>> queryStaffInfo(Map<String, Object> param,IPage page,StringBuilder whereSql);

    Map<String ,String> selectStaffInfoByName();
}
