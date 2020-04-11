package com.spring.lightrain.repository;

import com.spring.lightrain.dataobject.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video,String> {
    List<Video> findByUsername(String username);
    //List<Video> findByVideoTitle(String videoTitle);
}
