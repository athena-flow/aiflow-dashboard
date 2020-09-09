package com.aiflow.dashboard.wx.service;

import com.github.zhangchunsheng.amapdirection.bean.result.Distance;
import com.github.zhangchunsheng.amapdirection.bean.result.DistanceResult;
import com.github.zhangchunsheng.amapdirection.service.DirectionService;
import com.github.zhangchunsheng.amapgeo.bean.result.RegeoResult;
import com.github.zhangchunsheng.amapgeo.bean.result.Regeocode;
import com.github.zhangchunsheng.amapgeo.exception.AmapGeoException;
import com.github.zhangchunsheng.amapgeo.service.GeoService;
import com.github.zhangchunsheng.amapplace.bean.result.Poi;
import com.github.zhangchunsheng.amapplace.bean.result.PoiSearchResult;
import com.github.zhangchunsheng.amapplace.service.PlaceService;
import com.aiflow.dashboard.core.util.ResponseUtil;
import com.aiflow.dashboard.wx.dto.LocationInfo;
import com.aiflow.dashboard.wx.dto.PlaceSearch;
import me.zhangchunsheng.amap.common.exception.AmapException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapService {
    private final Log logger = LogFactory.getLog(MapService.class);

    @Autowired
    private GeoService geoService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private DirectionService directionService;

    /**
     * {
     "ret_code":200,
     "ret_msg":"OK",
     "result":{
     "data":{
     "count":0,
     "duration":1,
     "car_image_url":false,
     "max_show_near_car_num":3,
     "nearest_car":{

     },
     "location_info":{
         "province":"北京市",
         "city":"北京市",
         "name":"北京",
         "district":"朝阳区",
         "street":"朝阳门外大街",
         "street_number":"34号",
         "business":"",
         "formatted_address":"北京市朝阳区人民政府",
         "building_name":"北京市朝阳区人民政府",
         "short":"bj",
         "en":"BeiJing",
         "lng":116.44355,
         "lat":39.9219,
         "code":"010",
         "country":"CN",
         "timezone":"Asia\/Shanghai",
         "region_code":110000
     },
     "car_list":[

     ],
     "show_too_few_car_tip":1,
     "recommend_startaddr_list":[

     ]
     }
     },
     }
     * @param location 经纬度
     * @return LocationInfo
     */
    public LocationInfo location(String location) {
        LocationInfo locationInfo = new LocationInfo();
        LocationInfo.Location locationDto = new LocationInfo.Location();
        locationInfo.setLocationInfo(locationDto);
        try {
            RegeoResult data = geoService.regeo(location);
            if(data.getStatus().equals("1")) {
                Regeocode regeo = data.getRegeocode();
                locationDto.setFormattedAddress(regeo.getFormattedAddress());
                String city = LocationInfo.DEFAULT_CITY;
                if(regeo.getAddressComponent().getCity() instanceof List) {
                    city = regeo.getAddressComponent().getProvince();
                } else {
                    city = regeo.getAddressComponent().getCity().toString();
                }
                locationDto.setCity(city);

                String[] locationArray = location.split(",");
                locationDto.setLng(Double.valueOf(locationArray[0]));
                locationDto.setLat(Double.valueOf(locationArray[1]));
                locationDto.setCode(regeo.getAddressComponent().getCitycode());
                locationDto.setRegionCode(Integer.valueOf(regeo.getAddressComponent().getAdcode()));
                locationDto.setProvince(regeo.getAddressComponent().getProvince());
                locationDto.setDistrict(regeo.getAddressComponent().getDistrict());
            }
        } catch(AmapGeoException e) {
            logger.error("amap regeo error, location:" + location, e);
        }
        return locationInfo;
    }

    public List<PlaceSearch> placeSearch(String city, String keywords) {
        List<PlaceSearch> list = new ArrayList<PlaceSearch>();

        try {
            PoiSearchResult data = placeService.placeText(city, keywords, "1", "20");
            if(data.getStatus().equals("1")) {
                List<Poi> pois = data.getPois();
                for(int i = 0; i < pois.size(); i++) {
                    if(pois.get(i).getAddress() instanceof List) {
                        continue;
                    }
                    PlaceSearch place = new PlaceSearch();
                    String[] locationArray = pois.get(i).getLocation().split(",");
                    place.setCity(pois.get(i).getCityName());
                    place.setLng(Double.valueOf(locationArray[0]));
                    place.setLat(Double.valueOf(locationArray[1]));

                    place.setAddress(pois.get(i).getAddress().toString());
                    place.setName(pois.get(i).getName());
                    place.setPoiId(pois.get(i).getId());
                    list.add(place);
                }
            }
        } catch(AmapException e) {
            logger.error(String.format("amap placeText error, city:%s, keywords:%s", city, keywords), e);
        }
        return list;
    }

    public List<Distance> distance(String origins, String destination, int type) {
        List<Distance> list = new ArrayList<>();
        try {
            DistanceResult data = directionService.distance(origins, destination, type);
            if(data.getStatus().equals("1")) {
                list = data.getDistances();
            }
        } catch(AmapException e) {
            logger.error(String.format("amap distance error, origins:%s, destination:%s", origins, destination), e);
        }
        return list;
    }
}
