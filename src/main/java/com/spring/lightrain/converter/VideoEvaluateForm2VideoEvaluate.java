package com.spring.lightrain.converter;

import com.spring.lightrain.dataobject.VideoEvaluate;
import com.spring.lightrain.form.VideoEvaluateForm;

public class VideoEvaluateForm2VideoEvaluate {
    public static VideoEvaluate convert(VideoEvaluateForm form){
        return new VideoEvaluate(form.getVideoId(),form.getUsername(),
                Integer.parseInt(form.getVideoScore()),
                form.getVideoEvaluateDetail());
    }

    public static VideoEvaluateForm reConvert(VideoEvaluate videoEvaluate){
        return new VideoEvaluateForm(videoEvaluate.getVideoId(),videoEvaluate.getUsername(),
                videoEvaluate.getVideoScore()+"",
                videoEvaluate.getVideoEvaluateDetail());
    }
}
