package com.bookmark.service.service;


import com.bookmark.service.dao.model.UserInfo;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    void save(UserInfo userInfo);


    void updateUserInfo(UserInfo userInfo);

    UserInfo findByUsername(String username);
}
