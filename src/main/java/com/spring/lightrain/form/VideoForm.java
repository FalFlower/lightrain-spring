package com.spring.lightrain.form;



import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class VideoForm {
    @NotEmpty(message = "视频ID必填")
    private String videoId;

    @NotEmpty(message = "用户ID必填")
    private String username;

    @NotEmpty(message = "视频标题必填")
    private String videoTitle;//视频标题

    @NotEmpty(message = "视频简介必填")
    private String videoBrief;//视频简介

    @NotEmpty(message = "视频平均评分必填")
    private String videoScoreAva;    //视频平均评分

    @NotEmpty(message = "视频总时长必填")
    private String videoTime;    //视频总时长

    @NotEmpty(message = "视频价格D必填")
    private String videoPrice;    //视频价格

    @NotEmpty(message = "视频学习总人数必填")
    private String videoLearningNum;    //视频学习总人数

    @NotEmpty(message = "视频图片必填")
    private String videoIcon;    //视频图片

    @NotEmpty(message = "视频资源必填")
    private String videoUrl;    //视频资源

    @NotEmpty(message = "视频标签必填")
    private String videoLabel;    //视频标签

    public VideoForm(@NotEmpty(message = "视频ID必填") String videoId, @NotEmpty(message = "用户ID必填") String username, @NotEmpty(message = "视频标题必填") String videoTitle, @NotEmpty(message = "视频简介必填") String videoBrief, @NotEmpty(message = "视频平均评分必填") String videoScoreAva, @NotEmpty(message = "视频总时长必填") String videoTime, @NotEmpty(message = "视频价格D必填") String videoPrice, @NotEmpty(message = "视频学习总人数必填") String videoLearningNum, @NotEmpty(message = "视频图片必填") String videoIcon, @NotEmpty(message = "视频资源必填") String videoUrl, @NotEmpty(message = "视频标签必填") String videoLabel) {
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

    public VideoForm() {
    }
}
