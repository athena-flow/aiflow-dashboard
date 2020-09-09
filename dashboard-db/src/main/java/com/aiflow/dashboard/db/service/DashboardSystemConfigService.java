package com.aiflow.dashboard.db.service;

import com.aiflow.dashboard.db.dao.DashboardSystemMapper;
import com.aiflow.dashboard.db.domain.DashboardSystem;
import com.aiflow.dashboard.db.domain.DashboardSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardSystemConfigService {
    @Resource
    private DashboardSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        DashboardSystemExample example = new DashboardSystemExample();
        example.or().andDeletedEqualTo(false);

        List<DashboardSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (DashboardSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        DashboardSystemExample example = new DashboardSystemExample();
        example.or().andKeyNameLike("dashboard_mall_%").andDeletedEqualTo(false);
        List<DashboardSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(DashboardSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        DashboardSystemExample example = new DashboardSystemExample();
        example.or().andKeyNameLike("dashboard_wx_%").andDeletedEqualTo(false);
        List<DashboardSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(DashboardSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        DashboardSystemExample example = new DashboardSystemExample();
        example.or().andKeyNameLike("dashboard_order_%").andDeletedEqualTo(false);
        List<DashboardSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(DashboardSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        DashboardSystemExample example = new DashboardSystemExample();
        example.or().andKeyNameLike("dashboard_express_%").andDeletedEqualTo(false);
        List<DashboardSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(DashboardSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            DashboardSystemExample example = new DashboardSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            DashboardSystem system = new DashboardSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        DashboardSystem system = new DashboardSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
