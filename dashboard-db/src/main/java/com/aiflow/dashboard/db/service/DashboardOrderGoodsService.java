package com.aiflow.dashboard.db.service;

import com.aiflow.dashboard.db.dao.DashboardOrderGoodsMapper;
import com.aiflow.dashboard.db.domain.DashboardOrderGoods;
import com.aiflow.dashboard.db.domain.DashboardOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardOrderGoodsService {
    @Resource
    private DashboardOrderGoodsMapper orderGoodsMapper;

    public int add(DashboardOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<DashboardOrderGoods> queryByOid(Integer orderId) {
        DashboardOrderGoodsExample example = new DashboardOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<DashboardOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        DashboardOrderGoodsExample example = new DashboardOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public DashboardOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(DashboardOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        DashboardOrderGoodsExample example = new DashboardOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        DashboardOrderGoodsExample example = new DashboardOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }

    public void deleteByOrderId(Integer orderId) {
        DashboardOrderGoodsExample example = new DashboardOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        orderGoodsMapper.logicalDeleteByExample(example);
    }
}
