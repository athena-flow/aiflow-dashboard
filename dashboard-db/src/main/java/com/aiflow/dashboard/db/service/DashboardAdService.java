package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardAdMapper;
import com.aiflow.dashboard.db.domain.DashboardAd;
import com.aiflow.dashboard.db.domain.DashboardAdExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardAdService {
    @Resource
    private DashboardAdMapper adMapper;

    public List<DashboardAd> queryIndex() {
        DashboardAdExample example = new DashboardAdExample();
        example.or().andPositionEqualTo((byte) 1).andDeletedEqualTo(false).andEnabledEqualTo(true);
        return adMapper.selectByExample(example);
    }

    public List<DashboardAd> querySelective(String name, String content, Integer page, Integer limit, String sort, String order) {
        DashboardAdExample example = new DashboardAdExample();
        DashboardAdExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adMapper.selectByExample(example);
    }

    public int updateById(DashboardAd ad) {
        ad.setUpdateTime(LocalDateTime.now());
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    public void deleteById(Integer id) {
        adMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(DashboardAd ad) {
        ad.setAddTime(LocalDateTime.now());
        ad.setUpdateTime(LocalDateTime.now());
        adMapper.insertSelective(ad);
    }

    public DashboardAd findById(Integer id) {
        return adMapper.selectByPrimaryKey(id);
    }
}
