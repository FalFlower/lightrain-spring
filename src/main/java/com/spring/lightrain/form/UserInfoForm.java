package com.spring.lightrain.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserInfoForm {
    @NotEmpty(message = "姓名必填")
    private String username;

    @NotEmpty(message = "手机号必填")
    private String password;

    @NotEmpty(message = "昵称必填")
    private String nickName;

    @NotEmpty(message = "头像必填")
    private String userIcon;

    @NotEmpty(message = "性别必填")
    private String userGender;

    @NotEmpty(message = "生日必填")
    private String userBirthday;

    @NotEmpty(message = "学校必填")
    private String userSchool;

    @NotEmpty(message = "签名必填")
    private String userSign;

    @NotEmpty(message = "地区必填")
    private String userLocation;

    @NotEmpty(message = "用户身份")
    private String userIdentity;

    public UserInfoForm() {
    }

    public UserInfoForm(@NotEmpty(message = "姓名必填") String username, @NotEmpty(message = "手机号必填") String password, @NotEmpty(message = "昵称必填") String nickName, @NotEmpty(message = "头像必填") String userIcon, @NotEmpty(message = "性别必填") String userGender, @NotEmpty(message = "生日必填") String userBirthday, @NotEmpty(message = "学校必填") String userSchool, @NotEmpty(message = "签名必填") String userSign, @NotEmpty(message = "地区必填") String userLocation, @NotEmpty(message = "用户身份") String userIdentity) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.userIcon = userIcon;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.userSchool = userSchool;
        this.userSign = userSign;
        this.userLocation = userLocation;
        this.userIdentity = userIdentity;
    }
}
