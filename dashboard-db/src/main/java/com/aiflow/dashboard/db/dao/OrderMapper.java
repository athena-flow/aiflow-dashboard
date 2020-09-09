package com.aiflow.dashboard.db.dao;

import org.apache.ibatis.annotations.Param;
import com.aiflow.dashboard.db.domain.DashboardOrder;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") DashboardOrder order);
}