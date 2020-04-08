package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static jdk.nashorn.internal.objects.NativeMath.log;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoServiceImplTest {
    @Autowired
    UserInfoServiceImpl service;
    @Test
    public void login() {
        UserInfo userInfo=service.login("15244482896","123456");
        System.out.println(userInfo);
        Assert.assertEquals("123456",userInfo.getPassword());

    }

    @Test
    public void register() {
//        UserInfo userInfo=new UserInfo("13562663180","123456","dad","http://zt-data.test.upcdn.net/icon.jpg",
//                1,"1976-1-1",44,"StayHome",0);
//        service.register(userInfo);
//        log("register",service.getUserInfo(userInfo.getUsername()));
    }

    @Test
    public void logout() {
    }

    @Test
    public void getUserInfo() {
    }
}