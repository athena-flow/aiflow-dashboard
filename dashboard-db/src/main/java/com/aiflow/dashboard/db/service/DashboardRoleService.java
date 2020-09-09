package com.aiflow.dashboard.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardRoleMapper;
import com.aiflow.dashboard.db.domain.DashboardRole;
import com.aiflow.dashboard.db.domain.DashboardRoleExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DashboardRoleService {
    @Resource
    private DashboardRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        DashboardRoleExample example = new DashboardRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<DashboardRole> roleList = roleMapper.selectByExample(example);

        for(DashboardRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<DashboardRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        DashboardRoleExample example = new DashboardRoleExample();
        DashboardRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public DashboardRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(DashboardRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(DashboardRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        DashboardRoleExample example = new DashboardRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<DashboardRole> queryAll() {
        DashboardRoleExample example = new DashboardRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
