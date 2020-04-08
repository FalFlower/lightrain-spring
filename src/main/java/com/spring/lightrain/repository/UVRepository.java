package com.spring.lightrain.repository;

import com.spring.lightrain.dataobject.UV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UVRepository extends JpaRepository<UV,String> {
    List<UV> findAllByUsername(String username);
    List<UV> findUVSByVideoId(String videoId);
    UV findByVideoIdAndUsername(String videoId,String username);
}
