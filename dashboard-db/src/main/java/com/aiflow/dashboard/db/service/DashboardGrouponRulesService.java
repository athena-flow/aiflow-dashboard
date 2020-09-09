package com.aiflow.dashboard.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.aiflow.dashboard.db.dao.DashboardGoodsMapper;
import com.aiflow.dashboard.db.dao.DashboardGrouponRulesMapper;
import com.aiflow.dashboard.db.domain.DashboardGoods;
import com.aiflow.dashboard.db.domain.DashboardGrouponRules;
import com.aiflow.dashboard.db.domain.DashboardGrouponRulesExample;
import com.aiflow.dashboard.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardGrouponRulesService {
    @Resource
    private DashboardGrouponRulesMapper mapper;
    @Resource
    private DashboardGoodsMapper goodsMapper;
    private DashboardGoods.Column[] goodsColumns = new DashboardGoods.Column[]{DashboardGoods.Column.id, DashboardGoods.Column.name, DashboardGoods.Column.brief, DashboardGoods.Column.picUrl, DashboardGoods.Column.counterPrice, DashboardGoods.Column.retailPrice};

    public int createRules(DashboardGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public DashboardGrouponRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<DashboardGrouponRules> queryByGoodsId(Integer goodsId) {
        DashboardGrouponRulesExample example = new DashboardGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        DashboardGrouponRulesExample example = new DashboardGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int)mapper.countByExample(example);
    }

    public List<DashboardGrouponRules> queryByStatus(Short status) {
        DashboardGrouponRulesExample example = new DashboardGrouponRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购规则列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<DashboardGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<DashboardGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        DashboardGrouponRulesExample example = new DashboardGrouponRulesExample();
        example.or().andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购规则是否已经过期
     *
     * @return
     */
    public boolean isExpired(DashboardGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购规则列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<DashboardGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        DashboardGrouponRulesExample example = new DashboardGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        DashboardGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(DashboardGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}