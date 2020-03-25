package com.spring.lightrain.controller;

import com.spring.lightrain.VO.ResultVO;
import com.spring.lightrain.converter.UserInfoForm2UserInfo;
import com.spring.lightrain.dataobject.UserInfo;
import com.spring.lightrain.enums.ResultEnum;
import com.spring.lightrain.exception.RainException;
import com.spring.lightrain.form.UserInfoForm;
import com.spring.lightrain.service.UserInfoService;
import com.spring.lightrain.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController//返回gson格式
@RequestMapping("user")
@Slf4j
public class UserInfoController {
    @Autowired
    UserInfoService service;

    @GetMapping("login")
    public ResultVO<UserInfo> login(@RequestParam("username") String username,
                                    @RequestParam("password") String password){
        return ResultVOUtil.success(service.login(username,password));
    }

    @PostMapping("register")
    public ResultVO<UserInfo> register(@Valid UserInfoForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("用户注册失败，传递参数错误",form);
            throw new RainException(ResultEnum.REGISTER_FAILED_BY_PARAM.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultVOUtil.success(service.register(UserInfoForm2UserInfo.convert(form)));
    }

    @GetMapping("logout")
    public ResultVO<UserInfo> logout(@RequestParam("username") String username){
        service.logout(username);
        return ResultVOUtil.success();
    }

    @PostMapping("update")
    public ResultVO<UserInfo> update(@Valid UserInfoForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("用户更新个人信息失败，传递参数错误",form);
            throw new RainException(ResultEnum.UPDATE_FAILED.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        service.update(UserInfoForm2UserInfo.convert(form));
        return ResultVOUtil.success();
    }

}
