package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardSearchHistoryMapper;
import com.aiflow.dashboard.db.domain.DashboardSearchHistory;
import com.aiflow.dashboard.db.domain.DashboardSearchHistoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardSearchHistoryService {
    @Resource
    private DashboardSearchHistoryMapper searchHistoryMapper;

    public void save(DashboardSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<DashboardSearchHistory> queryByUid(int uid) {
        DashboardSearchHistoryExample example = new DashboardSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, DashboardSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        DashboardSearchHistoryExample example = new DashboardSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<DashboardSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        DashboardSearchHistoryExample example = new DashboardSearchHistoryExample();
        DashboardSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
