package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:16:26
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询所有菜单
     * @return
     */
    @Select("select * from menu")
    List<Menu> getAllMenu();

}
