package com.aiflow.dashboard.wx.web;

import com.github.zhangchunsheng.amapdirection.bean.result.DistanceResult;
import com.github.zhangchunsheng.amapdirection.service.DirectionService;
import com.github.zhangchunsheng.amapgeo.bean.result.GeoResult;
import com.github.zhangchunsheng.amapgeo.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapgeo.exception.AmapGeoException;
import com.github.zhangchunsheng.amapgeo.service.GeoService;
import com.github.zhangchunsheng.amapplace.bean.result.InputTips;
import com.github.zhangchunsheng.amapplace.bean.result.PoiSearchResult;
import com.github.zhangchunsheng.amapplace.service.PlaceService;
import com.aiflow.dashboard.core.util.ResponseUtil;
import me.zhangchunsheng.amap.common.exception.AmapException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * amap 服务
 */
@RestController
@RequestMapping("/wx/amap")
@Validated
public class WxAmapController {
    private final Log logger = LogFactory.getLog(WxAmapController.class);

    @Autowired
    private GeoService geoService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private DirectionService directionService;

    /**
     * 地址解析
     *
     * @param address 地址
     * @param city 城市
     * @return GeoResult
     */
    @GetMapping("geo")
    public Object geo(@RequestParam(defaultValue = "中国技术交易大厦") String address,
                        @RequestParam(defaultValue = "北京") String city) {
        try {
            GeoResult data = geoService.geo(address, city);
            if(data.getStatus().equals("1")) {
                return ResponseUtil.ok(data.getGeocodes());
            } else {
                return ResponseUtil.fail(Integer.valueOf(data.getInfoCode()), data.getInfo());
            }
        } catch(AmapGeoException e) {
            return ResponseUtil.fail(Integer.valueOf(e.getReturnInfoCode()), e.getReturnInfo());
        }
    }

    /**
     * 逆地址解析
     *
     * @param location 经纬度
     * @return RegeoResult
     */
    @GetMapping("regeo")
    public Object regeo(@RequestParam(defaultValue = "116.307487,39.984123") String location) {
        try {
            RegeoResult data = geoService.regeo(location);
            if(data.getStatus().equals("1")) {
                return ResponseUtil.ok(data.getRegeocode());
            } else {
                return ResponseUtil.fail(Integer.valueOf(data.getInfoCode()), data.getInfo());
            }
        } catch(AmapGeoException e) {
            return ResponseUtil.fail(Integer.valueOf(e.getReturnInfoCode()), e.getReturnInfo());
        }
    }

    /**
     * 输入提示
     *
     * @param city 城市
     * @param keywords 关键字
     * @return InputTips
     */
    @GetMapping("inputtips")
    public Object inputTips(@RequestParam(defaultValue = "北京") String city,
                            @RequestParam(defaultValue = "交易大厦") String keywords) {
        try {
            InputTips data = placeService.inputTips(city, keywords);
            if(data.getStatus().equals("1")) {
                return ResponseUtil.ok(data.getTips());
            } else {
                return ResponseUtil.fail(Integer.valueOf(data.getInfoCode()), data.getInfo());
            }
        } catch(AmapException e) {
            return ResponseUtil.fail(Integer.valueOf(e.getReturnInfoCode()), e.getReturnInfo());
        }
    }

    /**
     * 关键字搜索
     *
     * @param city 城市
     * @param keywords 关键字
     * @param page 当前页数 最大翻页数100
     * @param offset 每页记录数据 强烈建议不超过25，若超过25可能造成访问报错
     * @return PoiSearchResult
     */
    @GetMapping("placetext")
    public Object placeText(@RequestParam(defaultValue = "北京") String city,
                            @RequestParam(defaultValue = "交易大厦") String keywords,
                            @RequestParam(defaultValue = "1") String page,
                            @RequestParam(defaultValue = "20") String offset) {
        try {
            PoiSearchResult data = placeService.placeText(city, keywords, page, offset);
            if(data.getStatus().equals("1")) {
                return ResponseUtil.ok(data.getPois());
            } else {
                return ResponseUtil.fail(Integer.valueOf(data.getInfoCode()), data.getInfo());
            }
        } catch(AmapException e) {
            return ResponseUtil.fail(Integer.valueOf(e.getReturnInfoCode()), e.getReturnInfo());
        }
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
        try {
            DistanceResult data = directionService.distance(origins, destination, type);
            if(data.getStatus().equals("1")) {
                return ResponseUtil.ok(data.getDistances());
            } else {
                return ResponseUtil.fail(Integer.valueOf(data.getInfoCode()), data.getInfo());
            }
        } catch(AmapException e) {
            return ResponseUtil.fail(Integer.valueOf(e.getReturnInfoCode()), e.getReturnInfo());
        }
    }
}
