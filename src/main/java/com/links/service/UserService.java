package com.links.service;


import com.links.dao.entity.UserInfo;

public interface UserService {

    void save(UserInfo userInfo);

    UserInfo findByUsername(String username);

}
