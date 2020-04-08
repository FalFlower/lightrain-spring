package com.spring.lightrain.form;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VideoEvaluateForm {
    @NotEmpty(message = "视频ID不为空")
    private String videoId;

    @NotEmpty(message = "用户ID不为空")
    private String username;

    @NotEmpty(message = "视频评分不为空")
    private String videoScore;

    @NotEmpty(message = "视频评论详情不为空")
    private String VideoEvaluateDetail;

    public VideoEvaluateForm(@NotEmpty(message = "视频ID不为空") String videoId, @NotEmpty(message = "用户ID不为空") String username, @NotEmpty(message = "视频评分不为空") String videoScore, @NotEmpty(message = "视频评论详情不为空") String videoEvaluateDetail) {
        this.videoId = videoId;
        this.username = username;
        this.videoScore = videoScore;
        VideoEvaluateDetail = videoEvaluateDetail;
    }

    public VideoEvaluateForm() {
    }
}
