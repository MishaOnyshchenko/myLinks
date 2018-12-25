package com.links.service;




import com.links.controller.LinkController;
import com.links.dao.entity.Role;
import com.links.dao.entity.UserInfo;
import com.links.dao.repository.RoleRepo;
import com.links.dao.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    static final Logger log = LoggerFactory.getLogger(LinkController.class);


    @Override
    @Transactional
    public void save(UserInfo userInfo) {

        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));

        Role createRole = new Role("ROLE_USER");
        roleRepo.addRole(createRole);
        log.info("!!!!!!!!!!!!!!!Send role to Repo-------------" + createRole.getName());


        Role receivedRole = roleRepo.getRoleById(1L);
        log.info("!!!!!!!!!!!!!!!Received from Repo-------------" + receivedRole.getName());

        Set<Role> roles = new HashSet<>(Collections.singleton(receivedRole));
        userInfo.setRoles(roles);

        log.info("!!!!!! Will be sent to UserRepository " + userInfo);
        log.info("roles: " + roles);

        userRepo.saveUser(userInfo);



    }

//    @Override
//    @Transactional
//    public void updateUserInfo(UserInfo userInfo){
//        userRepository.saveAndFlush(userInfo);
//    }

    @Override
    public UserInfo findByUsername(String username) {
        return userRepo.findByUsername(username);

    }
}
