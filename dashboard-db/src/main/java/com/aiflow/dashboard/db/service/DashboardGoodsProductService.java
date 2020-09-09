package com.aiflow.dashboard.db.service;

import com.aiflow.dashboard.db.dao.GoodsProductMapper;
import com.aiflow.dashboard.db.dao.DashboardGoodsProductMapper;
import com.aiflow.dashboard.db.domain.DashboardGoodsProduct;
import com.aiflow.dashboard.db.domain.DashboardGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardGoodsProductService {
    @Resource
    private DashboardGoodsProductMapper dashboardGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<DashboardGoodsProduct> queryByGid(Integer gid) {
        DashboardGoodsProductExample example = new DashboardGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return dashboardGoodsProductMapper.selectByExample(example);
    }

    public DashboardGoodsProduct findById(Integer id) {
        return dashboardGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        dashboardGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(DashboardGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        dashboardGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        DashboardGoodsProductExample example = new DashboardGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) dashboardGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        DashboardGoodsProductExample example = new DashboardGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        dashboardGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }

    public void updateById(DashboardGoodsProduct product) {
        product.setUpdateTime(LocalDateTime.now());
        dashboardGoodsProductMapper.updateByPrimaryKeySelective(product);
    }
}