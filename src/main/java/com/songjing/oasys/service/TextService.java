package com.songjing.oasys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Text;

/**
 * (Text)表服务接口
 *
 * @author songjing
 * @since 2021-04-16 14:49:13
 */
public interface TextService extends IService<Text> {

    /**
     * 获取有效的内推政策
     *
     * @return
     */
    Text policyPush();

}
