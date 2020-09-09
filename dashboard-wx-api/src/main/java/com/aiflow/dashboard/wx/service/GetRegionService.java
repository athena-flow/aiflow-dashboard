package com.aiflow.dashboard.wx.service;

import com.aiflow.dashboard.db.domain.DashboardRegion;
import com.aiflow.dashboard.db.service.DashboardRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

	@Autowired
	private DashboardRegionService regionService;

	private static List<DashboardRegion> dashboardRegions;

	protected List<DashboardRegion> getDashboardRegions() {
		if(dashboardRegions==null){
			createRegion();
		}
		return dashboardRegions;
	}

	private synchronized void createRegion(){
		if (dashboardRegions == null) {
			dashboardRegions = regionService.getAll();
		}
	}
}
