package com.spring.lightrain.dataobject.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.lightrain.utils.Date2LongSerializer;
import lombok.Data;

import java.util.Date;
@Data
public class UvDTO {
    private String username;

    private String videoId;

    private int videoProgress;//用户观看时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date videoTimeLearning;//用户观看视频时间(最近的一次)

}
