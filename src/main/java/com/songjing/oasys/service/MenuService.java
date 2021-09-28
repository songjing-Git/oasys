package com.songjing.oasys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Menu;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:16:26
 */
public interface MenuService extends IService<Menu> {

    /**
     * getAllMenu
     *
     * @return
     */
    List<Menu> getAllMenu();


}
