package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardFootprintMapper;
import com.aiflow.dashboard.db.domain.DashboardFootprint;
import com.aiflow.dashboard.db.domain.DashboardFootprintExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardFootprintService {
    @Resource
    private DashboardFootprintMapper footprintMapper;

    public List<DashboardFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        DashboardFootprintExample example = new DashboardFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(DashboardFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public DashboardFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public DashboardFootprint findById(Integer userId, Integer id) {
        DashboardFootprintExample example = new DashboardFootprintExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return footprintMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(DashboardFootprint footprint) {
        footprint.setAddTime(LocalDateTime.now());
        footprint.setUpdateTime(LocalDateTime.now());
        footprintMapper.insertSelective(footprint);
    }

    public List<DashboardFootprint> querySelective(String userId, String goodsId, Integer page, Integer size, String sort, String order) {
        DashboardFootprintExample example = new DashboardFootprintExample();
        DashboardFootprintExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }
}
