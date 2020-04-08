package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.VideoEvaluate;
import com.spring.lightrain.repository.VideoEvaluateRepository;
import com.spring.lightrain.service.VideoEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoEvaluateServiceImpl implements VideoEvaluateService {
    @Autowired
    VideoEvaluateRepository repository;

    @Override
    public List<VideoEvaluate> findAllEvaluateByVideoId(String videoId) {
        return repository.findByVideoId(videoId);
    }

    @Override
    public List<VideoEvaluate> findAllEvaluateByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public VideoEvaluate updateVideoEvaluate(VideoEvaluate videoEvaluate) {
        return repository.save(videoEvaluate);
    }

    @Override
    public VideoEvaluate getVideoEvaluate(String videoId, String username) {
        return repository.findByVideoIdAndUsername(videoId,username);
    }
}
