package com.aiflow.dashboard.db.service;

import com.aiflow.dashboard.db.dao.DashboardPermissionMapper;
import com.aiflow.dashboard.db.domain.DashboardPermission;
import com.aiflow.dashboard.db.domain.DashboardPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DashboardPermissionService {
    @Resource
    private DashboardPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        DashboardPermissionExample example = new DashboardPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<DashboardPermission> permissionList = permissionMapper.selectByExample(example);

        for(DashboardPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        DashboardPermissionExample example = new DashboardPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<DashboardPermission> permissionList = permissionMapper.selectByExample(example);

        for(DashboardPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        DashboardPermissionExample example = new DashboardPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        DashboardPermissionExample example = new DashboardPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(DashboardPermission dashboardPermission) {
        dashboardPermission.setAddTime(LocalDateTime.now());
        dashboardPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(dashboardPermission);
    }
}
