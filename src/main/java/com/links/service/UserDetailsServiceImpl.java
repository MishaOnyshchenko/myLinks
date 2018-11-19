package com.bookmark.service.service.impl;


import com.bookmark.service.dao.model.Role;
import com.bookmark.service.dao.model.UserInfo;
import com.bookmark.service.dao.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userRepository.findByUsername(username);
        System.out.println("get user info from db {}"  + userInfo);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : userInfo.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        System.out.println(" set to grantedAuthoritie roles from user info : {}"+ grantedAuthorities);
        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), grantedAuthorities);
    }
}
