package com.songjing.oasys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songjing.oasys.entity.Role;

import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author songjing
 * @since 2021-03-16 15:17:07
 */
public interface RoleService extends IService<Role> {

    /**
     *
     * @return
     */
    List<String> selectRoleName();

}
