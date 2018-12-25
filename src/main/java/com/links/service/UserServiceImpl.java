package com.links.service;




import com.links.dao.entity.Role;
import com.links.dao.entity.UserInfo;
import com.links.dao.repository.RoleRepo;
import com.links.dao.repository.RoleRepository;
import com.links.dao.repository.UserRepo;
import com.links.dao.repository.UserRepository;
import com.links.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserRepo userRepo;


//    @Autowired
//    private RoleRepository roleRepository;

    @Autowired
    private RoleRepo roleRepo;



//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(UserInfo userInfo) {
//        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
//        Role role = roleRepository.getOne(1L);
        Role role = new Role("USER");
        roleRepo.addRole(role);
//        Role roleFromDb = roleRepo.addRole();

        System.out.println("!!!!!!!!!!!!!!!Get role-------------" + role.getName());

        Set<Role> roles = new HashSet<>(Collections.singleton(role));
        userInfo.setRoles(roles);
        System.out.println("!!!!!! Will be sent to UserRepository " + userInfo);
        System.out.println(roles);
//        userRepository.save(userInfo);
//        userRepository.saveAndFlush(userInfo);


//        System.out.println("!!! received from repo: "  + userRepository.findByUsername(userInfo.getUsername()).getUsername());

    }

//    @Override
//    @Transactional
//    public void updateUserInfo(UserInfo userInfo){
//        userRepository.saveAndFlush(userInfo);
//    }

    @Override
    public UserInfo findByUsername(String username) {
        return userRepo.findByUsername(username);
//        return userRepository.findByUsername(username);
    }
}
