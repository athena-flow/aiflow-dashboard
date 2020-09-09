package com.aiflow.dashboard.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.aiflow.dashboard.admin.vo.RegionVo;
import com.aiflow.dashboard.core.util.ResponseUtil;
import com.aiflow.dashboard.db.domain.DashboardRegion;
import com.aiflow.dashboard.db.service.DashboardRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private DashboardRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<DashboardRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<DashboardRegion> dashboardRegions = regionService.getAll();
        Map<Byte, List<DashboardRegion>> collect = dashboardRegions.stream().collect(Collectors.groupingBy(DashboardRegion::getType));
        byte provinceType = 1;
        List<DashboardRegion> provinceList = collect.get(provinceType);
        byte cityType = 2;
        List<DashboardRegion> city = collect.get(cityType);
        Map<Integer, List<DashboardRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(DashboardRegion::getPid));
        byte areaType = 3;
        List<DashboardRegion> areas = collect.get(areaType);
        Map<Integer, List<DashboardRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(DashboardRegion::getPid));

        for (DashboardRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<DashboardRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (DashboardRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(cityVo.getId());
                cityVO.setName(cityVo.getName());
                cityVO.setCode(cityVo.getCode());
                cityVO.setType(cityVo.getType());

                List<DashboardRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (DashboardRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
