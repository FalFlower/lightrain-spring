package com.spring.lightrain.service;

import com.spring.lightrain.dataobject.UserRelationship;

public interface UserRelationshipService {
    UserRelationship update(UserRelationship userRelationship);
    UserRelationship getUserRelationship(String username);
}
