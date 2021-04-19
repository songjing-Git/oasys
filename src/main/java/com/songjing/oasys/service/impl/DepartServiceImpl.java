package com.songjing.oasys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Depart;
import com.songjing.oasys.mapper.DepartMapper;
import com.songjing.oasys.service.DepartService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 部门表(Depart)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:13:16
 */
@Service
@Slf4j
public class DepartServiceImpl extends ServiceImpl<DepartMapper, Depart> implements DepartService {

    @Resource
    DepartMapper departMapper;

    @Override
    public IPage selectDepartInfo(Map<String,Object> param) {
        log.info("==============param:"+param);
        IPage page=new Page<>();
        if (param.containsKey("current")){
            page.setCurrent(Long.parseLong(param.get("current").toString()));
        }
        if (param.containsKey("pageSize")){
            page.setSize(Long.parseLong(param.get("pageSize").toString()));
        }
        QueryWrapper<Depart> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(Maps.isNotEmpty(param,"depart_id"),"depart_id",param.get("depart_id"))
                .eq(Maps.isNotEmpty(param,"depart_name"),"depart_name",param.get("depart_name"))
                .eq(Maps.isNotEmpty(param,"depart_mgr"),"depart_mgr","depart_mgr");

        return departMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Map<String ,Object>> selectDepartName() {
        List<Depart> departs = departMapper.selectList(null);
        List<Map<String ,Object>> departNameList = new ArrayList<>();
        if (!departs.isEmpty()){
            for (Depart depart: departs) {
                Map<String, Object> departMap = JSON.parseObject(JSON.toJSONString(depart),
                        new TypeReference<Map<String, Object>>() {});
                departNameList.add(departMap);
            }
        }


        return departNameList;
    }

    @Override
    public int insertDepart(Depart depart) {
        log.info("===============depart:"+depart);
        return departMapper.insert(depart);
    }

    @Override
    public int removeById(int id) {
        return departMapper.deleteById(id);
    }
}
