package com.spring.lightrain.enums;

import lombok.Getter;

@Getter
public enum  UserStatusEnum {
    LOGIN(1,"已登录"),
    LOGOUT(0,"已注销"),
    STUDENT(2,"学生"),
    TEACHER(3,"老师");
    private Integer code;
    private String msg;

    UserStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
