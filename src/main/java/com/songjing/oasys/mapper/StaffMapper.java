package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * (Staff)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:15:49
 */
@Mapper
@Repository
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * SpringSecurity
     * @param username
     * @return
     */
    @Select("select * from staff where user_name=#{username}")
    Staff loadUserByUsername(String username);

    /**
     * 根据id查询名称
     * @param staffId
     * @return
     */
    @Select("select staff_name from staff where staff_id=#{staffId}")
    String selectStaffNameById(int staffId);
}
