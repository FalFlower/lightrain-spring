package com.spring.lightrain.converter;

import com.spring.lightrain.dataobject.UserInfo;
import com.spring.lightrain.form.UserInfoForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class UserInfoForm2UserInfo {
    public static UserInfo convert(UserInfoForm form) {
        int age=0,status=0;
        String[] bir=form.getUserBirthday().split("-");
        age=2020-Integer.parseInt(bir[0]);
        return new UserInfo(form.getUsername(),form.getPassword(),form.getNickName(),
                form.getUserIcon(),Integer.parseInt(form.getUserGender()),form.getUserBirthday(),age,
                form.getUserSchool(),status);
    }
}
