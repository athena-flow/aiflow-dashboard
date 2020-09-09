package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardCategoryMapper;
import com.aiflow.dashboard.db.domain.DashboardCategory;
import com.aiflow.dashboard.db.domain.DashboardCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardCategoryService {
    @Resource
    private DashboardCategoryMapper categoryMapper;
    private DashboardCategory.Column[] CHANNEL = {DashboardCategory.Column.id, DashboardCategory.Column.name, DashboardCategory.Column.iconUrl};

    public List<DashboardCategory> queryL1WithoutRecommend(int offset, int limit) {
        DashboardCategoryExample example = new DashboardCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<DashboardCategory> queryL1(int offset, int limit) {
        DashboardCategoryExample example = new DashboardCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<DashboardCategory> queryL1() {
        DashboardCategoryExample example = new DashboardCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<DashboardCategory> queryByPid(Integer pid) {
        DashboardCategoryExample example = new DashboardCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<DashboardCategory> queryL2ByIds(List<Integer> ids) {
        DashboardCategoryExample example = new DashboardCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public DashboardCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<DashboardCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        DashboardCategoryExample example = new DashboardCategoryExample();
        DashboardCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    public int updateById(DashboardCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(DashboardCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<DashboardCategory> queryChannel() {
        DashboardCategoryExample example = new DashboardCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
