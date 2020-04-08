package com.spring.lightrain.repository;

import com.spring.lightrain.dataobject.VideoEvaluate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoEvaluateRepository extends JpaRepository<VideoEvaluate,String> {
    List<VideoEvaluate> findByUsername(String username);
    List<VideoEvaluate> findByVideoId(String videoId);
    VideoEvaluate findByVideoIdAndUsername(String videoId,String username);
}
