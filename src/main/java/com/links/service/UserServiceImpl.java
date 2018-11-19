package com.bookmark.service.service.impl;




import com.bookmark.service.dao.model.Role;
import com.bookmark.service.dao.model.UserInfo;
import com.bookmark.service.dao.repository.RoleRepository;
import com.bookmark.service.dao.repository.UserRepository;
import com.bookmark.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        Role role = roleRepository.getOne(1L);
        Set<Role> roles = new HashSet<>(Collections.singleton(role));
        userInfo.setRoles(roles);
        System.out.println(userInfo);
        System.out.println(roles);
        userRepository.save(userInfo);
    }
    @Override
    @Transactional
    public void updateUserInfo(UserInfo userInfo){
        userRepository.saveAndFlush(userInfo);
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
