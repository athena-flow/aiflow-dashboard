package com.aiflow.dashboard.wx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceSearch {
    private String name = "北京城建N次方";
    private double lng = 116.423565;
    private double lat = 40.052458;
    private String city = "北京";
    private String address = "水岸南街16号";
    @JsonProperty("poi_id")
    private String poiId = "a_B000A9EV0X";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
}
