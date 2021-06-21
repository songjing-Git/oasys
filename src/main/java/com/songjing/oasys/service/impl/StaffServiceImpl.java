package com.songjing.oasys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songjing.oasys.entity.*;
import com.songjing.oasys.mapper.*;
import com.songjing.oasys.service.StaffService;
import com.songjing.oasys.utils.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (Staff)表服务实现类
 *
 * @author songjing
 * @since 2021-03-16 15:15:49
 */
@Service
@Slf4j
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService  {

    @Resource
    StaffMapper staffMapper;

    @Resource
    DepartMapper departMapper;

    @Resource
    JobLevelMapper jobLevelMapper;

    @Resource
    SalaryMapper salaryMapper;

    @Resource
    UserRoleMapper userRoleMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public IPage queryStaffInfo(Map<String, Object> param) {
        IPage<Map<String, Object>> page=new Page<>();
        if (param.containsKey("current")){
            page.setCurrent(Long.parseLong(param.get("current").toString()));
        }
        if (param.containsKey("pageSize")){
            page.setSize(Long.parseLong(param.get("pageSize").toString()));
        }
        Integer departId=null ;
        Integer jobLevelId=null;
        if (Maps.isNotEmpty(param,"depart_name")){
            QueryWrapper<Depart> queryDepartWrapper=new QueryWrapper<Depart>();
            queryDepartWrapper.eq("depart_name",param.get("depart_name"));
            Depart depart = departMapper.selectOne(queryDepartWrapper);
            departId=depart.getDepartId();
        }

        if (Maps.isNotEmpty(param,"job_level_name")) {
            QueryWrapper<JobLevel> queryJobLevelWrapper=new QueryWrapper<JobLevel>();
            queryJobLevelWrapper.eq("job_level_name",param.get("job_level_name"));
            JobLevel jobLevel = jobLevelMapper.selectOne(queryJobLevelWrapper);
            jobLevelId=jobLevel.getJobLevelId();
        }

        QueryWrapper<Staff> queryStaffWrapper=new QueryWrapper<>();
        queryStaffWrapper.eq(Maps.isNotEmpty(param,"staff_id"),"staff_id",param.get("staff_id"))
                .eq(Maps.isNotEmpty(param,"staff_name"),"staff_name",param.get("staff_name"))
                .eq(Maps.isNotEmpty(param,"depart_id"),"depart_id",param.get("depart_id"))
                .eq(null!=departId,"depart_id",departId)
                .eq(Maps.isNotEmpty(param,"phone"),"phone",param.get("phone"))
                .eq(Maps.isNotEmpty(param,"email"),"email",param.get("email"))
                .eq(null!=jobLevelId,"job_level_id",jobLevelId);
        return getiPage(page, queryStaffWrapper);
    }

    @Override
    public Map<String, Object> selectStaffInfoByName(String username) {
        //获取员工对象
        QueryWrapper<Staff> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        Staff staff = staffMapper.selectOne(queryWrapper);
        log.info("=============> staff:"+staff);
        //获取员工的角色权限信息
        List<UserRole> roleByStaffId = userRoleMapper.getRoleByUserName(staff.getStaffId());
        log.info(String.valueOf(roleByStaffId));
        List<Role> roles=new ArrayList<>();
        for (UserRole uRole:roleByStaffId) {
            Role roleById = roleMapper.getRoleById(uRole.getRoleId());
            roles.add(roleById);
        }
        staff.setRoles(roles);
        //对象转map
        Map<String, Object> staffMap = JSON.parseObject(JSON.toJSONString(staff),
                new TypeReference<Map<String, Object>>() {});
        //处理员工信息
        //处理员工的部门信息
        if (Maps.isNotEmpty(staffMap,"departId")) {
            Object departCode = staffMap.get("departId");
            Integer deptId = Integer.valueOf(departCode.toString());
            QueryWrapper<Depart> queryDepartWrapper=new QueryWrapper<>();
            queryDepartWrapper.eq("depart_id",deptId);
            Depart depart = departMapper.selectOne(queryDepartWrapper);
            Map<String, Object> departMap = JSON.parseObject(JSON.toJSONString(depart),
                    new TypeReference<Map<String, Object>>() {});
            staffMap.putAll(departMap);
        }
        //处理员工的职位信息
        if (Maps.isNotEmpty(staffMap,"jobLevelId")) {
            QueryWrapper<JobLevel> queryJobLevelWrapper=new QueryWrapper<>();
            queryJobLevelWrapper.eq("job_level_id",staffMap.get("jobLevelId"));
            JobLevel jobLevel = jobLevelMapper.selectOne(queryJobLevelWrapper);
            Map<String, Object> jobLevelMap = JSON.parseObject(JSON.toJSONString(jobLevel),
                    new TypeReference<Map<String, Object>>() {});
            staffMap.putAll(jobLevelMap);
        }

        return staffMap;
    }

    @Override
    public int insertStaff(Map<String, Object> param) {
        log.info("================param:"+param);
        Integer departId=null ;
        Integer jobLevelId=null ;
        if (param.containsKey("depart_name")) {
            departId= departMapper.selectDepartIdByDepartName(param.get("depart_name").toString());
        }
        if (param.containsKey("job_level_name")) {
            jobLevelId=jobLevelMapper.selectJobLevelIdByName(param.get("job_level_name").toString());
        }
        String password = passwordEncoder.encode(param.get("password").toString());
        Staff staff = JSON.parseObject(JSON.toJSONString(param), Staff.class);
        staff.setPassword(password);
        staff.setDepartId(departId);
        staff.setJobLevelId(jobLevelId);
        log.info("===============staff");
        int insert = staffMapper.insert(staff);
        log.info("===============insert:"+insert);
        return insert;
    }

    @Override
    public int updateStaff(Map<String, Object> param) {
        if (param.get("staffId")==null){
            return 0;
        }
        Staff staff = new Staff();
        staff.setStaffId(Integer.valueOf(param.get("staffId").toString()));
        Integer departId =null;
        Integer jobLevelId=null;
        log.info("================param:"+param);
        if (Maps.isNotEmpty(param,"staffId")){
            Staff staffInfo = staffMapper.selectById(Integer.valueOf(param.get("staffId").toString()));
            if (null==staffInfo){
                throw new RuntimeException("没有找到该员工");
            }
        }
        if (Maps.isNotEmpty(param,"changeType")){
            if (!("Dept").equals(param.get("changeType"))){
                if (Maps.isNotEmpty(param,"jobLevelName")) {
                    jobLevelId = jobLevelMapper.selectJobLevelIdByName(param.get("jobLevelName").toString());
                }
            }
            if (!("Post").equals(param.get("changeType"))) {
                if (Maps.isNotEmpty(param,"departName")){
                    departId = departMapper.selectDepartIdByDepartName(param.get("departName").toString());
                }
            }
        }
        QueryWrapper<Staff> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(departId!=null,"depart_id",departId)
                .eq(jobLevelId!=null,"job_level_id",jobLevelId);
        return  staffMapper.update(staff, queryWrapper);
    }

    @Override
    public IPage selectNoDeptStaff(int current, int pageSize) {
        log.info("===========> current:"+current);
        log.info("===========> pageSize:"+pageSize);
        IPage<Map<String, Object>> page=new Page<>();
        page.setCurrent(current);
        page.setSize(pageSize);
        QueryWrapper<Staff> queryStaffWrapper=new QueryWrapper<>();
        queryStaffWrapper.isNull("depart_id");
        return getiPage(page, queryStaffWrapper);
    }

    @Override
    public int updateStaffInfo(Staff staff) {
        String encode = passwordEncoder.encode(staff.getPassword());
        staff.setPassword(encode);
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("staff_id",staff.getStaffId());
        return staffMapper.update(staff,queryWrapper);
    }

    private IPage getiPage(IPage<Map<String, Object>> page, QueryWrapper<Staff> queryStaffWrapper) {
        IPage<Map<String, Object>> staffInfoPage = staffMapper.selectMapsPage(page, queryStaffWrapper);
        for (Map<String,Object> staff:staffInfoPage.getRecords()) {
            if (Maps.isNotEmpty(staff,"depart_id")) {
                Object departCode = staff.get("depart_id");
                Integer deptId = Integer.valueOf(departCode.toString());
                QueryWrapper<Depart> queryDepartWrapper=new QueryWrapper<>();
                queryDepartWrapper.eq("depart_id",deptId);
                Depart depart = departMapper.selectOne(queryDepartWrapper);
                Map<String, Object> departMap = JSON.parseObject(JSON.toJSONString(depart),
                        new TypeReference<Map<String, Object>>() {});
                staff.putAll(departMap);
            }

            if (Maps.isNotEmpty(staff,"job_level_id")) {
                QueryWrapper<JobLevel> queryJobLevelWrapper=new QueryWrapper<>();
                queryJobLevelWrapper.eq("job_level_id",staff.get("job_level_id"));
                JobLevel jobLevel = jobLevelMapper.selectOne(queryJobLevelWrapper);
                Map<String, Object> jobLevelMap = JSON.parseObject(JSON.toJSONString(jobLevel),
                        new TypeReference<Map<String, Object>>() {});
                staff.putAll(jobLevelMap);
            }

            if (Maps.isNotEmpty(staff,"salary_id")) {
                QueryWrapper<Salary> salaryQueryWrapper=new QueryWrapper<>();
                salaryQueryWrapper.eq("salary_id",staff.get("salary_id"));
                Salary salary = salaryMapper.selectOne(salaryQueryWrapper);
                Map<String, Object> salaryMap = JSON.parseObject(JSON.toJSONString(salary),
                        new TypeReference<Map<String, Object>>() {});
                staff.putAll(salaryMap);
            }

            if (Maps.isNotEmpty(staff,"work_state")) {
                if ("0".equals(staff.get("work_state").toString())){
                    staff.put("workStateName","离职");
                } else {
                    staff.put("workStateName","在职");
                }
            }


        }
        return staffInfoPage;
    }


}
