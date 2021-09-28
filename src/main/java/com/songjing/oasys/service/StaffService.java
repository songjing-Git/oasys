package com.songjing.oasys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Staff;

import java.util.Map;

/**
 * (Staff)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:15:48
 */
public interface StaffService extends IService<Staff> {

    /**
     * 根据条件查询员工信息
     *
     * @param param
     * @return
     */
    IPage queryStaffInfo(Map<String, Object> param);

    /**
     * 根据员工名称查询员工信息
     *
     * @param username
     * @return
     */
    Map<String, Object> selectStaffInfoByName(String username);

    /**
     * 新增员工接口
     *
     * @param param
     * @return
     */
    int insertStaff(Map<String, Object> param);

    /**
     * 更新员工信息
     *
     * @param param
     * @return
     */
    int updateStaff(Map<String, Object> param);


    /**
     * 查询没有部门的员工
     *
     * @param current
     * @param pageSize
     * @return
     */
    IPage selectNoDeptStaff(int current, int pageSize);


    /**
     * 更新员工基本信息
     *
     * @param staff
     * @return
     */
    int updateStaffInfo(Staff staff);
}
