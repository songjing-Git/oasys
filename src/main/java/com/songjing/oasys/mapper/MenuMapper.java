package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Menu)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:16:26
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

}
