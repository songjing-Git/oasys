package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Depart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 部门表(Depart)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:10:45
 */
@Mapper
@Repository
public interface DepartMapper extends BaseMapper<Depart> {

    /**
     * 通过部门名称查询部门id
     * @param departName
     * @return
     */
    @Select("select depart_id from depart_name=#{departName}")
    int selectDepartIdByDepartName(String departName);

    /**
     * 通过部门id删除部门
     * @param id
     * @return
     */
    @Select("delete from depart where depart_id=#{id} ")
    int deleteById(int id);
}
