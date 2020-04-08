package com.spring.lightrain.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.lightrain.utils.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@IdClass(UV.class)
public class UV implements Serializable{
    @Id
    private String username;
    @Id
    private String videoId;

    private int videoProgress;//用户观看时间

    private Date videoTimeLearning;//用户观看视频时间(最近的一次)

    public UV(String username, String videoId, int videoProgress, Date videoTimeLearning) {
        this.username = username;
        this.videoId = videoId;
        this.videoProgress = videoProgress;
        this.videoTimeLearning = videoTimeLearning;
    }

    public UV() {
    }
}
