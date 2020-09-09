package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardRegionMapper;
import com.aiflow.dashboard.db.domain.DashboardRegion;
import com.aiflow.dashboard.db.domain.DashboardRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DashboardRegionService {

    @Resource
    private DashboardRegionMapper regionMapper;

    public List<DashboardRegion> getAll(){
        DashboardRegionExample example = new DashboardRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<DashboardRegion> queryByPid(Integer parentId) {
        DashboardRegionExample example = new DashboardRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public DashboardRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<DashboardRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        DashboardRegionExample example = new DashboardRegionExample();
        DashboardRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
