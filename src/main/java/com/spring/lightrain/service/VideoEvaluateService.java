package com.spring.lightrain.service;

import com.spring.lightrain.dataobject.VideoEvaluate;

import java.util.List;

public interface VideoEvaluateService {
    List<VideoEvaluate> findAllEvaluateByVideoId(String videoId);
    List<VideoEvaluate> findAllEvaluateByUsername(String username);
    VideoEvaluate updateVideoEvaluate(VideoEvaluate videoEvaluate);
    VideoEvaluate getVideoEvaluate(String videoId,String username);
}
