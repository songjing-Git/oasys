package com.songjing.oasys.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.songjing.oasys.entity.Menu;
import com.songjing.oasys.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author songjing
 * @since 2021-03-16 15:16:26
 */
@RestController
@RequestMapping("menu")
public class MenuController extends ApiController {

    @Resource
    MenuService menuService;

    @PostMapping("getAll")
    @ApiOperation("获取所有菜单")
    public List<Menu> getAllMenu() {
        return menuService.getAllMenu();
    }
}
