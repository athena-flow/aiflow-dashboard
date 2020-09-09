package com.aiflow.dashboard.db.service;

import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardTopicMapper;
import com.aiflow.dashboard.db.domain.DashboardGroupon;
import com.aiflow.dashboard.db.domain.DashboardTopic;
import com.aiflow.dashboard.db.domain.DashboardTopic.Column;
import com.aiflow.dashboard.db.domain.DashboardTopicExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardTopicService {
    @Resource
    private DashboardTopicMapper topicMapper;
    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    public List<DashboardTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<DashboardTopic> queryList(int offset, int limit, String sort, String order) {
        DashboardTopicExample example = new DashboardTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        DashboardTopicExample example = new DashboardTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public DashboardTopic findById(Integer id) {
        DashboardTopicExample example = new DashboardTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<DashboardTopic> queryRelatedList(Integer id, int offset, int limit) {
        DashboardTopicExample example = new DashboardTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<DashboardTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        DashboardTopic topic = topics.get(0);

        example = new DashboardTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<DashboardTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<DashboardTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        DashboardTopicExample example = new DashboardTopicExample();
        DashboardTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(DashboardTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        DashboardTopicExample example = new DashboardTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(DashboardTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


    public void deleteByIds(List<Integer> ids) {
        DashboardTopicExample example = new DashboardTopicExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        DashboardTopic topic = new DashboardTopic();
        topic.setUpdateTime(LocalDateTime.now());
        topic.setDeleted(true);
        topicMapper.updateByExampleSelective(topic, example);
    }
}
