package com.songjing.oasys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Work;

import java.util.Map;

/**
 * (Work)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:11:03
 */
public interface WorkService extends IService<Work> {

    /**
     * 分页查询内推职位
     * @param param
     * @return
     */
    IPage selectWorkInfo( Map<String,Object> param);

}
