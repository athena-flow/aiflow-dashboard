package com.aiflow.dashboard.admin.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.aiflow.dashboard.db.domain.DashboardCoupon;
import com.aiflow.dashboard.db.domain.DashboardCouponUser;
import com.aiflow.dashboard.db.service.DashboardCouponService;
import com.aiflow.dashboard.db.service.DashboardCouponUserService;
import com.aiflow.dashboard.db.util.CouponConstant;
import com.aiflow.dashboard.db.util.CouponUserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 检测优惠券过期情况
 */
@Component
public class CouponJob {
    private final Log logger = LogFactory.getLog(CouponJob.class);

    @Autowired
    private DashboardCouponService couponService;
    @Autowired
    private DashboardCouponUserService couponUserService;

    /**
     * 每隔一个小时检查
     * TODO
     * 注意，因为是相隔一个小时检查，因此导致优惠券真正超时时间可能比设定时间延迟1个小时
     */
    @Scheduled(fixedDelay = 60 * 60 * 1000)
    public void checkCouponExpired() {
        logger.info("系统开启任务检查优惠券是否已经过期");

        List<DashboardCoupon> couponList = couponService.queryExpired();
        for (DashboardCoupon coupon : couponList) {
            coupon.setStatus(CouponConstant.STATUS_EXPIRED);
            couponService.updateById(coupon);
        }

        List<DashboardCouponUser> couponUserList = couponUserService.queryExpired();
        for (DashboardCouponUser couponUser : couponUserList) {
            couponUser.setStatus(CouponUserConstant.STATUS_EXPIRED);
            couponUserService.update(couponUser);
        }

        logger.info("系统结束任务检查优惠券是否已经过期");
    }

}
