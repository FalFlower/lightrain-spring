package com.spring.lightrain.service;

import com.spring.lightrain.dataobject.Video;

import java.util.List;

public interface VideoService {
        Video findVideo(String videoId);
        List<Video> findAllVideo();
        Video update(Video video);
        List<Video> findTeacherAllVideo(String username);
}
