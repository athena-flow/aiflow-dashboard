package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardFeedbackMapper;
import com.aiflow.dashboard.db.domain.DashboardFeedback;
import com.aiflow.dashboard.db.domain.DashboardFeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Peter
 * @date 2018/8/27 11:39
 */
@Service
public class DashboardFeedbackService {
    @Autowired
    private DashboardFeedbackMapper feedbackMapper;

    public Integer add(DashboardFeedback feedback) {
        feedback.setAddTime(LocalDateTime.now());
        feedback.setUpdateTime(LocalDateTime.now());
        return feedbackMapper.insertSelective(feedback);
    }

    public List<DashboardFeedback> querySelective(Integer userId, String username, Integer page, Integer limit, String sort, String order) {
        DashboardFeedbackExample example = new DashboardFeedbackExample();
        DashboardFeedbackExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return feedbackMapper.selectByExample(example);
    }
}
