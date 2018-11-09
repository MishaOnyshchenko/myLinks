//package com.links.service;
//
//
//import com.bookmark.service.dao.model.Bookmark;
//import com.bookmark.service.dao.model.MenuTittle;
//import com.bookmark.service.dao.model.UserInfo;
//import com.bookmark.service.dao.repository.BookMarkRepository;
//import com.bookmark.service.dao.repository.MenuTittleRepository;
//import com.bookmark.service.dao.repository.UserRepository;
//import com.bookmark.service.service.UserService;
//import com.links.dao.entity.CategoryEntity;
//import com.links.dao.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@Transactional
//public class CategoryService {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BookMarkRepository bookMarkRepository;
//    @Autowired
//    private UserService userService;
//
//
//    public List<CategoryEntity> menuTittles() {
//        List<CategoryEntity> menuTittles = Collections.emptyList();
//        menuTittles = menuTittleRepository.findAll();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//        List<MenuTittle> menuTittlesorShow = new ArrayList<>();
//
//        for (MenuTittle menuTittle : menuTittles) {
//            if (menuTittle.getUserInfo().getUsername().equals(name)) {
//                menuTittlesorShow.add(menuTittle);
//            }
//        }
//        return menuTittlesorShow;
//    }
//
//    public List<Bookmark> bookMarkList() {
//        List<MenuTittle> menuTittles = Collections.emptyList();
//        menuTittles = menuTittleRepository.findAll();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//        List<Bookmark> menuTittlesorShow = new ArrayList<>();
//
//        for (MenuTittle menuTittle : menuTittles) {
//            if (menuTittle.getUserInfo().getUsername().equals(name)) {
//                menuTittlesorShow.addAll(menuTittle.getBookmarkSet());
//            }
//        }
//        return menuTittlesorShow;
//    }
//
//    public void saveMenu(String tittle, String subGroup, String currentUserName) {
//        UserInfo userInfo = userService.findByUsername(currentUserName);
//        MenuTittle menuTittle = new MenuTittle();
//        menuTittle.setTittle(tittle);
//        menuTittle.setUserInfo(userInfo);
//        System.out.println("save menu ->"+menuTittle);
//        menuTittleRepository.saveAndFlush(menuTittle);
//    }
//
//    public void saveBookMark(String currentUser, String tittle, String link, String shortDescription, String currentTittle) {
//        //    UserInfo userInfor = userRepository.findByUsername(currentUser);
//        MenuTittle menuTittle = menuTittleRepository.findByTittle(currentTittle);
//        Bookmark bookmark = new Bookmark();
//        bookmark.setTittle(tittle);
//        bookmark.setLink(link);
//        bookmark.setShortDescription(shortDescription);
//        bookmark.setMenuTittle(menuTittle);
//
//        System.out.println("save bookmark ->"+bookmark);
//        bookMarkRepository.saveAndFlush(bookmark);
//
//
//    }
//}
