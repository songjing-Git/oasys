package com.songjing.oasys.pub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.pub.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (City)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:13:03
 */
@Mapper
@Repository
public interface CityMapper extends BaseMapper<City> {

}
