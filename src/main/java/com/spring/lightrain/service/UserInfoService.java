package com.spring.lightrain.service;

import com.spring.lightrain.dataobject.UserInfo;

public interface UserInfoService {
    UserInfo login(String username,String password);
    UserInfo register(UserInfo userInfo);
    void logout(String username);
    UserInfo getUserInfo(String username);
    UserInfo update(UserInfo userInfo);
}
