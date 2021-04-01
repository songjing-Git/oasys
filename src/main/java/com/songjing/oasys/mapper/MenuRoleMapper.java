package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (MenuRole)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:16:39
 */
@Mapper
@Repository
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

}
