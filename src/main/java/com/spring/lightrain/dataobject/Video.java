package com.spring.lightrain.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@Data
public class Video {
    @Id
    private String videoId;
    private String username;
    //视频标题
    private String videoTitle;
    //视频简介
    private String videoBrief;
    //视频平均评分
    private float videoScoreAva;
    //视频总时长
    private int videoTime;
    //视频价格
    private float videoPrice;
    //视频学习总人数
    private int videoLearningNum;
    //视频图片
    private String videoIcon;
    //视频资源
    private String videoUrl;
    //视频标签
    private String videoLabel;

    public Video(String videoId, String username, String videoTitle, String videoBrief, float videoScoreAva, int videoTime, float videoPrice, int videoLearningNum, String videoIcon, String videoUrl, String videoLabel) {
        this.videoId = videoId;
        this.username = username;
        this.videoTitle = videoTitle;
        this.videoBrief = videoBrief;
        this.videoScoreAva = videoScoreAva;
        this.videoTime = videoTime;
        this.videoPrice = videoPrice;
        this.videoLearningNum = videoLearningNum;
        this.videoIcon = videoIcon;
        this.videoUrl = videoUrl;
        this.videoLabel = videoLabel;
    }

    public Video() { }

}
