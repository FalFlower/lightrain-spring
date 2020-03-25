package com.spring.lightrain.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo {
    @Id
    private String username;

    private String password;

    private String nickname;

    private String userIcon;

    private int userGender;

    private String userBirthday;

    private int userAge;

    private String userSchool;

    private int userStatus;

    public UserInfo() {
    }

    public UserInfo(String username,String password) {
        this.username=username;
        this.password=password;
    }

    public UserInfo(String username, String password, String nickname, String userIcon, int userGender, String userBirthday, int userAge, String userSchool, int userStatus) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.userIcon = userIcon;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.userAge = userAge;
        this.userSchool = userSchool;
        this.userStatus = userStatus;
    }

    public UserInfo(String nickname, String userIcon, int userGender, String userBirthday, int userAge, String userSchool, int userStatus) {
        this.nickname = nickname;
        this.userIcon = userIcon;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.userAge = userAge;
        this.userSchool = userSchool;
        this.userStatus = userStatus;
    }
}
