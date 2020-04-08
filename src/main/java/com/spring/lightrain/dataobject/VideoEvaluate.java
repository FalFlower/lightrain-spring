package com.spring.lightrain.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@Data
@IdClass(VideoEvaluate.class)
public class VideoEvaluate implements Serializable{
    @Id
    private String videoId;

    @Id
    private String username;

    private int videoScore;

    private String VideoEvaluateDetail;

    public VideoEvaluate(String videoId, String username, int videoScore, String videoEvaluateDetail) {
        this.videoId = videoId;
        this.username = username;
        this.videoScore = videoScore;
        VideoEvaluateDetail = videoEvaluateDetail;
    }

    public VideoEvaluate() {
    }

}
