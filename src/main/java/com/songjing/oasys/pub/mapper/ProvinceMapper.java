package com.songjing.oasys.pub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songjing.oasys.pub.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Province)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:16:56
 */
@Mapper
@Repository
public interface ProvinceMapper extends BaseMapper<Province> {

}
