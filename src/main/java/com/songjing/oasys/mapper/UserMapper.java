package com.songjing.oasys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (User)表服务接口
 *
 * @author songjing
 * @since 2021-01-05 15:27:02
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}