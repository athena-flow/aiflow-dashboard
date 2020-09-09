package com.aiflow.dashboard.core.config;

import com.github.zhangchunsheng.amapgeo.config.AmapGeoConfig;
import com.github.zhangchunsheng.amapgeo.service.GeoService;
import com.github.zhangchunsheng.amapgeo.service.impl.GeoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmapGeoConfiguration {
    @Autowired
    private AmapGeoProperties properties;

    public AmapGeoProperties getProperties() {
        return properties;
    }

    public void setProperties(AmapGeoProperties properties) {
        this.properties = properties;
    }

    @Bean
    public AmapGeoConfig amapGeoConfig() {
        AmapGeoConfig amapConfig = new AmapGeoConfig();
        amapConfig.setKey(properties.getKey());
        return amapConfig;
    }


    @Bean
    public GeoService geoService(AmapGeoConfig amapConfig) {
        GeoService geoService = new GeoServiceImpl();
        geoService.setConfig(amapConfig);
        return geoService;
    }
}