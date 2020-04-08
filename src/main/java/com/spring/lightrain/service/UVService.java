package com.spring.lightrain.service;

import com.spring.lightrain.dataobject.UV;
import com.spring.lightrain.dataobject.dto.UvDTO;

import java.util.List;

public interface UVService {
    UV updateUV(UvDTO uvDTO);
    UV getUV(String videoId, String username);
    List<UV> getUserAllUV(String username);
    List<UV> getVideoAllUV(String videoId);
}
