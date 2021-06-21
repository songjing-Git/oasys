package com.songjing.oasys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.Depart;
import com.songjing.oasys.entity.Staff;
import com.songjing.oasys.mapper.DepartMapper;
import com.songjing.oasys.mapper.StaffMapper;
import com.songjing.oasys.service.DepartService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    StaffMapper staffMapper;

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
        queryWrapper.eq(Maps.isNotEmpty(param,"departId"),"depart_id",param.get("departId"))
                .eq(Maps.isNotEmpty(param,"departName"),"depart_name",param.get("departName"))
                .eq(Maps.isNotEmpty(param,"departMgr"),"depart_mgr","departMgr");

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

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int removeById(int id) {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("depart_id",id);
        List<Map<String, Object>> maps = staffMapper.selectMaps(queryWrapper);

        if (!maps.isEmpty()){
            List<Integer> intList=new ArrayList<>();
            for (Map<String, Object> map : maps) {
                int departId =Integer.parseInt(map.get("staff_id").toString()) ;
                intList.add(departId);
            }
            Staff staff = new Staff();
            staff.setDepartId(null);
            QueryWrapper<Staff> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.in("staff_id",intList);
            int update = staffMapper.update(staff, queryWrapper1);
            log.info("======update:"+update);
        }
        int i = departMapper.deleteById(id);
        log.info("==========> i:"+i);
        return i;
    }
}
