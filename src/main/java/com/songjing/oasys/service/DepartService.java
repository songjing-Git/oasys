package com.songjing.oasys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Depart;

import java.util.List;
import java.util.Map;

/**
 * 部门表(Depart)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:10:44
 */
public interface DepartService extends IService<Depart> {

    /**
     * 查询部门信息
     * @param param
     * @return
     */
    IPage selectDepartInfo(Map<String,Object> param);

    /**
     * 获取部门名称列表
     * @return
     */
    List<Map<String ,Object>> selectDepartName();


    /**
     * 添加部门
     * @param depart
     * @return
     */
    int insertDepart(Depart depart);

    /**
     * 通过id删除部门信息
     * @param id
     * @return
     */
    int removeById(int id);
}
