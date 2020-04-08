package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.Video;
import com.spring.lightrain.repository.VideoRepository;
import com.spring.lightrain.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoRepository repository;

    @Override
    public Video findVideo(String videoId) {
        return repository.findById(videoId).orElse(null);
    }

    @Override
    public List<Video> findAllVideo() {
        return repository.findAll();
    }

    @Override
    public Video update(Video video) {
        return repository.save(video);
    }

    @Override
    public List<Video> findTeacherAllVideo(String username) {
        return repository.findByUsername(username);
    }

}
