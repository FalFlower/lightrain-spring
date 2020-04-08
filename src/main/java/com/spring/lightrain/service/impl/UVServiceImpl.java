package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.UV;
import com.spring.lightrain.dataobject.dto.UvDTO;
import com.spring.lightrain.repository.UVRepository;
import com.spring.lightrain.service.UVService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UVServiceImpl implements UVService {
    @Autowired
    UVRepository repository;

    @Override
    public UV updateUV(UvDTO uvDTO) {
        UV uv=new UV();
        BeanUtils.copyProperties(uvDTO,uv);
        UV old=repository.findByVideoIdAndUsername(uv.getVideoId(),uv.getUsername());
        if (old!=null)
            repository.delete(old);
        repository.save(uv);

        return getUV(uv.getVideoId(),uv.getUsername());
    }

    @Override
    public UV getUV(String videoId, String username) {
        return repository.findByVideoIdAndUsername(videoId,username);
    }

    @Override
    public List<UV> getUserAllUV(String username) {
        return repository.findAllByUsername(username);
    }

    @Override
    public List<UV> getVideoAllUV(String videoId) {
        return repository.findUVSByVideoId(videoId);
    }
}
