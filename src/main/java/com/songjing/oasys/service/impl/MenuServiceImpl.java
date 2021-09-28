package com.songjing.oasys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Menu;
import com.songjing.oasys.mapper.MenuMapper;
import com.songjing.oasys.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:16:26
 */
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public List<Menu> getAllMenu() {
        //获取数据库菜单列表
        List<Menu> allMenu = menuMapper.getAllMenu();
        return buildMenuTree(allMenu, "0");
        /*return menuMapper.getAllMenu();*/
    }

    private List<Menu> buildMenuTree(List<Menu> menuList, String pid) {
        List<Menu> treeList = new ArrayList<>();
        menuList.forEach(menu -> {
            if (StringUtils.equals(pid, menu.getParentMenuId().toString())) {
                log.info("======menu:" + menu);
                log.info("==============menuList:" + menuList);
                menu.setChildren(buildMenuTree(menuList, menu.getMenuId().toString()));
                treeList.add(menu);
            }
        });
        return treeList;
    }
}
