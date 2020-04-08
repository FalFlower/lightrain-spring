package com.spring.lightrain.service.impl;

import com.spring.lightrain.dataobject.UserRelationship;
import com.spring.lightrain.repository.UserRelationshipRepository;
import com.spring.lightrain.service.UserRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRelationshipServiceImpl implements UserRelationshipService {
    @Autowired
    UserRelationshipRepository repository;

    @Override
    public UserRelationship update(UserRelationship userRelationship) {
        if (userRelationship!=null){
          return repository.save(userRelationship);
        }
        return null;
    }

    @Override
    public UserRelationship getUserRelationship(String username) {
        return repository.findById(username).orElse(null);
    }


}
