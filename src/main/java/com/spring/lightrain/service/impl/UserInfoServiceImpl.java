package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.UserInfo;
import com.spring.lightrain.enums.ResultEnum;
import com.spring.lightrain.exception.RainException;
import com.spring.lightrain.repository.UserInfoRepository;
import com.spring.lightrain.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfo userInfo;
    private static Integer STATUS_LOGOUT=0;
    private static Integer STATUS_LOGIN=1;

    @Autowired
    UserInfoRepository repository;

    @Override
    public UserInfo login(String username, String password) {
        userInfo=getUserInfo(username);
        if (userInfo==null||!userInfo.getPassword().equals(password))
            throw new RainException(ResultEnum.LOGIN_FAILED);
        else{
            userInfo.setUserStatus(STATUS_LOGIN);
            update(userInfo);
            return userInfo;
        }

    }

    @Override
    public UserInfo register(UserInfo userInfo) {

        if (getUserInfo(userInfo.getUsername())==null)
            return repository.save(userInfo);
        else
            throw new RainException(ResultEnum.REGISTER_FAILED);
    }

    @Override
    public void logout(String username) {
        userInfo=getUserInfo(username);
        if (userInfo==null||userInfo.getUserStatus()==STATUS_LOGOUT)
            throw new RainException(ResultEnum.LOGOUT_FAILED);
        userInfo.setUserStatus(STATUS_LOGOUT);
        repository.save(userInfo);
    }

    @Override
    public UserInfo getUserInfo(String username) {
        return repository.findById(username).orElse(null);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return repository.save(userInfo);
    }


}
