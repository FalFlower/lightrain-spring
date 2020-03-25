package com.spring.lightrain.repository;

import com.spring.lightrain.dataobject.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    //查询已登录用户
    //List<UserInfo> findByUserStatus(Integer userStatus);
}
