package com.spring.lightrain.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserRelationship {
    @Id
    private String username;

    private String userFans; //用户粉丝

    private int userFansNum;

    private String userFollows;//用户关注

    private int userFollowsNum;

    private int userIntegral;//用户积分

    private String userFavourites;//用户收藏

    public UserRelationship(String username, String userFans, int userFansNum, String userFollows, int userFollowsNum, int userIntegral, String userFavourites) {
        this.username = username;
        this.userFans = userFans;
        this.userFansNum = userFansNum;
        this.userFollows = userFollows;
        this.userFollowsNum = userFollowsNum;
        this.userIntegral = userIntegral;
        this.userFavourites = userFavourites;
    }

    public UserRelationship() {
    }
}
