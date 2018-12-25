package com.links.service;


import com.links.controller.LinkController;
import com.links.dao.entity.Role;
import com.links.dao.entity.UserInfo;
import com.links.dao.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service(value ="userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    static final Logger log = LoggerFactory.getLogger(LinkController.class);


    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userRepo.findByUsername(username);
        log.info("get user info from db {} "  + userInfo);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : userInfo.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        log.info("set to grantedAuthority roles from user info : {}"+ grantedAuthorities);

        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), grantedAuthorities);
    }
}
