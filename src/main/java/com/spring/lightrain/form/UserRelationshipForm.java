package com.spring.lightrain.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserRelationshipForm {
    @NotEmpty(message = "用户ID必填")
    private String username;

    @NotEmpty(message = "用户粉丝必填")
    private String userFans; //用户粉丝

    @NotEmpty(message = "用户粉丝数目必填")
    private String userFansNum;

    @NotEmpty(message = "用户关注必填")
    private String userFollows;//用户关注

    @NotEmpty(message = "用户关注数目必填")
    private String userFollowsNum;

    @NotEmpty(message = "用户积分数目必填")
    private String userIntegral;//用户积分

    @NotEmpty(message = "用户收藏列表必填")
    private String userFavourites;//用户收藏

    public UserRelationshipForm() {
    }

    public UserRelationshipForm(@NotEmpty(message = "用户ID必填") String username, @NotEmpty(message = "用户粉丝必填") String userFans, @NotEmpty(message = "用户粉丝数目必填") String userFansNum, @NotEmpty(message = "用户关注必填") String userFollows, @NotEmpty(message = "用户关注数目必填") String userFollowsNum, @NotEmpty(message = "用户积分数目必填") String userIntegral, @NotEmpty(message = "用户收藏列表必填") String userFavourites) {
        this.username = username;
        this.userFans = userFans;
        this.userFansNum = userFansNum;
        this.userFollows = userFollows;
        this.userFollowsNum = userFollowsNum;
        this.userIntegral = userIntegral;
        this.userFavourites = userFavourites;
    }
}
