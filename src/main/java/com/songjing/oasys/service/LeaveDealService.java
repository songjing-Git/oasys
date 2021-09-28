package com.songjing.oasys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.LeaveDeal;

import java.util.Map;

/**
 * (LeaveDeal)表服务接口
 *
 * @author songjing
 * @since 2021-05-19 14:59:36
 */
public interface LeaveDealService extends IService<LeaveDeal> {

    /**
     * 插入离职信息
     *
     * @param param
     * @return
     */
    int insertLeaveDealInfo(Map<String, Object> param);
}
