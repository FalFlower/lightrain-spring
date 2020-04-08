package com.spring.lightrain.converter;

import com.spring.lightrain.dataobject.Video;
import com.spring.lightrain.form.VideoForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoForm2Video {
    public static Video convert(VideoForm form){
        return new Video(form.getVideoId(),form.getUsername(),form.getVideoTitle(),
                form.getVideoBrief(),Float.parseFloat(form.getVideoScoreAva()),
                Integer.parseInt(form.getVideoTime()),Float.parseFloat(form.getVideoPrice()),
                Integer.parseInt(form.getVideoLearningNum()),
                form.getVideoIcon(),form.getVideoUrl(),form.getVideoLabel());
    }

    public static VideoForm reConvert(Video video){
        return new VideoForm(video.getVideoId(),video.getUsername(),video.getVideoTitle(),
                video.getVideoBrief(),video.getVideoScoreAva()+"",
                video.getVideoTime()+"", video.getVideoPrice()+"",
                video.getVideoLearningNum()+"",video.getVideoIcon(),
                video.getVideoUrl(),video.getVideoLabel());
    }
}
