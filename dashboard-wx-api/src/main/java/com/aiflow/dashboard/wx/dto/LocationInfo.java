package com.aiflow.dashboard.wx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationInfo {
    public final static String DEFAULT_CITY = "北京市";

    private int count = 0;

    @JsonProperty("location_info")
    private Location locationInfo;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Location getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(Location locationInfo) {
        this.locationInfo = locationInfo;
    }

    public static class Location {
        private String province = "北京市";
        private String city = "北京市";
        private String name = "北京";
        private String district = "朝阳区";
        private String street = "朝阳门外大街";
        @JsonProperty("street_number")
        private String streetNumber = "34号";
        private String business = "";
        @JsonProperty("formatted_address")
        private String formattedAddress = "北京市朝阳区人民政府";
        @JsonProperty("building_name")
        private String buildingName = "北京市朝阳区人民政府";
        @JsonProperty("short")
        private String cityShort = "bj";
        private String en = "BeiJing";
        private double lng = 116.44355;
        private double lat = 39.9219;
        private String code = "010";
        private String country = "CN";
        private String timezone = "Asia/Shanghai";
        @JsonProperty("region_code")
        private int regionCode = 110000;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getCityShort() {
            return cityShort;
        }

        public void setCityShort(String cityShort) {
            this.cityShort = cityShort;
        }

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public int getRegionCode() {
            return regionCode;
        }

        public void setRegionCode(int regionCode) {
            this.regionCode = regionCode;
        }
    }
}
