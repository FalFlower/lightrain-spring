package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.UserInfo;
import com.spring.lightrain.dataobject.UserRelationship;
import com.spring.lightrain.enums.ResultEnum;
import com.spring.lightrain.enums.UserStatusEnum;
import com.spring.lightrain.exception.RainException;
import com.spring.lightrain.repository.UserInfoRepository;
import com.spring.lightrain.repository.UserRelationshipRepository;
import com.spring.lightrain.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfo userInfo;


    @Autowired
    UserInfoRepository repository;
    @Autowired
    UserRelationshipServiceImpl service;

    @Override
    public UserInfo login(String username, String password) {
        userInfo=getUserInfo(username);
        if (userInfo.getUserStatus()==1)
            throw new RainException(ResultEnum.LOGIN_REPEAT);
        if (userInfo==null||!userInfo.getPassword().equals(password))
            throw new RainException(ResultEnum.LOGIN_FAILED);
        else{
            userInfo.setUserStatus(UserStatusEnum.LOGIN.getCode());
            update(userInfo);
            return userInfo;
        }

    }

    @Override
    public UserInfo register(UserInfo userInfo) {
        if (getUserInfo(userInfo.getUsername())==null){
            service.update(new UserRelationship(userInfo.getUsername(),
                            "",0,"",
                            0,0,""));//同步在user_relationship中注册
            return repository.save(userInfo);
        }
        else
            throw new RainException(ResultEnum.REGISTER_FAILED);
    }

    @Override
    public void logout(String username) {
        userInfo=getUserInfo(username);
        if (userInfo==null||userInfo.getUserStatus()==UserStatusEnum.LOGOUT.getCode())
            throw new RainException(ResultEnum.LOGOUT_FAILED);
        userInfo.setUserStatus(UserStatusEnum.LOGOUT.getCode());
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
