package com.aiflow.dashboard.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.aiflow.dashboard.core.qcode.QCodeService;
import com.aiflow.dashboard.db.domain.DashboardGoods;
import com.aiflow.dashboard.db.service.DashboardGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateShareImageTest {
    @Autowired
    QCodeService qCodeService;
    @Autowired
    DashboardGoodsService dashboardGoodsService;

    @Test
    public void test() {
        DashboardGoods good = dashboardGoodsService.findById(1181010);
        qCodeService.createGoodShareImage(good.getId().toString(), good.getPicUrl(), good.getName());
    }
}
