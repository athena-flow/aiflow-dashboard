package com.aiflow.dashboard.core.config;

import com.github.zhangchunsheng.amapdirection.service.DirectionService;
import com.github.zhangchunsheng.amapdirection.service.impl.DirectionServiceImpl;
import com.github.zhangchunsheng.amapplace.service.PlaceService;
import com.github.zhangchunsheng.amapplace.service.impl.PlaceServiceImpl;
import me.zhangchunsheng.amap.common.config.AmapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmapConfiguration {
    @Autowired
    private AmapProperties properties;

    public AmapProperties getProperties() {
        return properties;
    }

    public void setProperties(AmapProperties properties) {
        this.properties = properties;
    }

    @Bean
    public AmapConfig amapConfig() {
        AmapConfig amapConfig = new AmapConfig();
        amapConfig.setKey(properties.getKey());
        return amapConfig;
    }


    @Bean
    public PlaceService placeService(AmapConfig amapConfig) {
        PlaceService placeService = new PlaceServiceImpl();
        placeService.setConfig(amapConfig);
        return placeService;
    }

    @Bean
    public DirectionService directionService(AmapConfig amapConfig) {
        DirectionService directionService = new DirectionServiceImpl();
        directionService.setConfig(amapConfig);
        return directionService;
    }
}