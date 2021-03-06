package com.spring.lightrain.controller;

import com.spring.lightrain.VO.ResultVO;
import com.spring.lightrain.converter.UserInfoForm2UserInfo;
import com.spring.lightrain.dataobject.UserInfo;
import com.spring.lightrain.dataobject.UserRelationship;
import com.spring.lightrain.enums.ResultEnum;
import com.spring.lightrain.exception.RainException;
import com.spring.lightrain.form.UserInfoForm;
import com.spring.lightrain.form.UserRelationshipForm;
import com.spring.lightrain.service.UserInfoService;
import com.spring.lightrain.service.UserRelationshipService;
import com.spring.lightrain.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController//返回json格式
@RequestMapping("user")
@Slf4j
public class UserInfoController {
    @Autowired
    UserInfoService service;

    @Autowired
    UserRelationshipService relationshipService;

    @GetMapping("info")
    public ResultVO<UserInfo> getUserInfo(@RequestParam("username") String username){
        return ResultVOUtil.success(service.getUserInfo(username));
    }

    @GetMapping("login")
    public ResultVO<UserInfo> login(@RequestParam("username") String username,
                                    @RequestParam("password") String password){
        return ResultVOUtil.success(service.login(username,password));
    }

    @PostMapping("register")
    public ResultVO<UserInfo> register(@Valid UserInfoForm form, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("用户注册失败，传递参数错误",form);
            throw new RainException(ResultEnum.REGISTER_FAILED_BY_PARAM);
        }
        //用户已存在
        if (service.getUserInfo(form.getUsername())!=null)
            throw new RainException(ResultEnum.REGISTER_FAILED_BY_PARAM);
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
            throw new RainException(ResultEnum.UPDATE_FAILED);
        }
        return ResultVOUtil.success(service.update(UserInfoForm2UserInfo.convert(form)));
    }

    //用户关系
    @PostMapping("relationship/follow")
    public ResultVO<UserRelationship> follow(@RequestParam("username") String username,
                                             @RequestParam("userFollow") String userFollow){
        //更新个人用户关系表
        System.out.println("!!!!!!!!!!!!username"+username);
        UserRelationship relationship=relationshipService.getUserRelationship(username);
        if (relationship==null)
            throw new RainException(ResultEnum.FOLLOW_USER_RELATIONSHIP_FAILED);
        relationship.setUserFollowsNum(relationship.getUserFollowsNum()+1);
        relationship.setUserFollows(relationship.getUserFollows()+";"+userFollow);
        //更新对应用户关系表
        UserRelationship otherRelationship=relationshipService.getUserRelationship(userFollow);
        if (otherRelationship==null)
            throw new RainException(ResultEnum.UN_FOLLOW_USER_RELATIONSHIP_FAILED);
        otherRelationship.setUserFansNum(relationship.getUserFansNum()+1);
        otherRelationship.setUserFans(relationship.getUserFans()+";"+userFollow);
        relationshipService.update(otherRelationship);

        return ResultVOUtil.success(relationshipService.update(relationship));
    }

    @PostMapping("relationship/unFollow")
    public ResultVO<UserRelationship> unFollow(@RequestParam("username") String username,
                                               @RequestParam("userFollow") String userFollow){
        //更新个人用户关系表
        UserRelationship relationship=relationshipService.getUserRelationship(username);
        if (relationship==null)
            throw new RainException(ResultEnum.FOLLOW_USER_RELATIONSHIP_FAILED);
        relationship.setUserFollowsNum(relationship.getUserFollowsNum()-1);
        relationship.setUserFollows(removeUserRelationshipList(relationship.getUserFollows(),userFollow));
        //更新对应用户关系表
        UserRelationship otherRelationship=relationshipService.getUserRelationship(userFollow);
        if (otherRelationship==null)
            throw new RainException(ResultEnum.UN_FOLLOW_USER_RELATIONSHIP_FAILED);
        otherRelationship.setUserFansNum(relationship.getUserFansNum()-1);
        otherRelationship.setUserFans(removeUserRelationshipList(relationship.getUserFans(),userFollow));
        relationshipService.update(otherRelationship);

        return ResultVOUtil.success(relationshipService.update(relationship));
    }

    @PostMapping("relationship/update")
    public ResultVO<UserRelationship> update(@Valid UserRelationshipForm relationship, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error(ResultEnum.UPDATE_USER_RELATIONSHIP_FAILED.getMessage(),relationship);
            throw new RainException(ResultEnum.UPDATE_USER_RELATIONSHIP_FAILED);
        }
        return ResultVOUtil.success(
                relationshipService.
                        update(new UserRelationship(relationship.getUsername(),
                                relationship.getUserFans(),
                                Integer.parseInt(relationship.getUserFansNum()),
                                relationship.getUserFollows(),
                                Integer.parseInt(relationship.getUserFollowsNum()),
                                Integer.parseInt(relationship.getUserIntegral()),
                                relationship.getUserFavourites())));
    }

    @GetMapping("relationship/info")
    public ResultVO<UserRelationship> getInfo(@RequestParam("username") String username){
        if (!username.equals("")){
            return ResultVOUtil.success(relationshipService.getUserRelationship(username));
        }else
            throw new RainException(ResultEnum.GET_USER_RELATIONSHIP_FAILED);
    }
    //移除用户关系中粉丝、关注、收藏字段
    private String removeUserRelationshipList(String data,String remove){
        String regex = ";";
        String[] list=data.split(regex);
        StringBuilder msg= new StringBuilder();
        for (String s : list) {
            if (!s.equals("")){
                if (!s.equals(remove))
                    msg.append(s).append(regex);
            }
        }
        return msg.toString();
    }

}
