package com.aiflow.dashboard.db.service;

import com.aiflow.dashboard.db.dao.DashboardGoodsAttributeMapper;
import com.aiflow.dashboard.db.domain.DashboardGoodsAttribute;
import com.aiflow.dashboard.db.domain.DashboardGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardGoodsAttributeService {
    @Resource
    private DashboardGoodsAttributeMapper goodsAttributeMapper;

    public List<DashboardGoodsAttribute> queryByGid(Integer goodsId) {
        DashboardGoodsAttributeExample example = new DashboardGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(DashboardGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public DashboardGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        DashboardGoodsAttributeExample example = new DashboardGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(DashboardGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
