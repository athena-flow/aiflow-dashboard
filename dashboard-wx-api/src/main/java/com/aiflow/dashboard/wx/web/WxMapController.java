package com.aiflow.dashboard.wx.web;

import com.github.zhangchunsheng.amapdirection.bean.result.Distance;
import com.github.zhangchunsheng.amapgeo.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapgeo.exception.AmapGeoException;
import com.aiflow.dashboard.core.util.ResponseUtil;
import com.aiflow.dashboard.wx.dto.LocationInfo;
import com.aiflow.dashboard.wx.dto.PlaceSearch;
import com.aiflow.dashboard.wx.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * YOP服务
 */
@RestController
@RequestMapping("/wx/map")
@Validated
public class WxMapController {
    @Autowired
    private MapService mapService;

    /**
     * Map定位
     *
     * @param location 经纬度
     * @return LocationInfo
     */
    @GetMapping("location")
    public Object location(@RequestParam(defaultValue = "116.307487,39.984123") String location) {
        LocationInfo data = mapService.location(location);
        return ResponseUtil.ok(data);
    }

    /**
     * 地址搜索
     *
     * @param city 城市
     * @param keywords 关键字
     * @return LocationInfo
     */
    @GetMapping("placesearch")
    public Object placeSearch(@RequestParam(defaultValue = "北京") String city,
                            @RequestParam(defaultValue = "技术交易大厦") String keywords) {
        List<PlaceSearch> data = mapService.placeSearch(city, keywords);
        return ResponseUtil.ok(data);
    }

    /**
     * 距离计算
     *
     * @param origins 出发点，支持100个坐标对，坐标对见用“| ”分隔；经度和纬度用","分隔
     * @param destination 目的地
     * @param type 路径计算的方式和方法
     * @return DistanceResult
     */
    @GetMapping("distance")
    public Object distance(@RequestParam(defaultValue = "116.481028,39.989643") String origins,
                              @RequestParam(defaultValue = "114.465302,40.004717") String destination,
                              @RequestParam(defaultValue = "1") Integer type) {
        List<Distance> data = mapService.distance(origins, destination, type);
        return ResponseUtil.ok(data);
    }
}
