package com.aiflow.dashboard.wx.service;

import com.aiflow.dashboard.db.domain.DashboardUser;
import com.aiflow.dashboard.db.service.DashboardUserService;
import com.aiflow.dashboard.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private DashboardUserService userService;


    public UserInfo getInfo(Integer userId) {
        DashboardUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
