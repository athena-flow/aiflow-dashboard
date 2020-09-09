package com.aiflow.dashboard.admin.dto;

import com.aiflow.dashboard.db.domain.DashboardGoods;
import com.aiflow.dashboard.db.domain.DashboardGoodsAttribute;
import com.aiflow.dashboard.db.domain.DashboardGoodsProduct;
import com.aiflow.dashboard.db.domain.DashboardGoodsSpecification;

public class GoodsAllinone {
    DashboardGoods goods;
    DashboardGoodsSpecification[] specifications;
    DashboardGoodsAttribute[] attributes;
    DashboardGoodsProduct[] products;

    public DashboardGoods getGoods() {
        return goods;
    }

    public void setGoods(DashboardGoods goods) {
        this.goods = goods;
    }

    public DashboardGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(DashboardGoodsProduct[] products) {
        this.products = products;
    }

    public DashboardGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(DashboardGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public DashboardGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(DashboardGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
