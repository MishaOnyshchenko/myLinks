// package com.links.config;//package service.bookmark.config;
//
//
// import com.links.dao.entity.Role;
// import com.links.dao.entity.UserInfo;
// import com.links.dao.repository.BookmarkRepository;
// import com.links.dao.repository.GroupsRepository;
// import com.links.dao.repository.RoleRepository;
// import com.links.dao.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.annotation.Transactional;
//
// import javax.annotation.PostConstruct;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.Set;
//
// @Transactional
// @Component
// public class InitDataToDb {
//
//     @Autowired
//     private UserRepository userRepository;
//     @Autowired
//     private BCryptPasswordEncoder bCryptPasswordEncoder;
//     @Autowired
//     private RoleRepository roleRepository;
//     @Autowired
//     private BookmarkRepository bookmarkRepository;
//     @Autowired
//     private GroupsRepository groupsRepository;
//
//     @PostConstruct
//     private void init() {
//
//         Role role1 = new Role();
//         role1.setId(1L);
//         role1.setName("admin");
//         roleRepository.save(role1);
//
//         Role role2 = new Role();
//         role2.setId(2L);
//         role2.setName("user");
//         roleRepository.save(role2);
//
//
//         UserInfo userInfo = new UserInfo();
//         userInfo.setUsername("boss@gmail.com");
//         userInfo.setPassword(bCryptPasswordEncoder.encode("12345678"));
//         Set<Role> roles = new HashSet<>(Collections.singleton(role1));
//         userInfo.setRoles(roles);
//         userRepository.save(userInfo);
//
//     }
//  }
