//package com.links.controller;
//
//import com.base.login.dao.model.UserInfo;
//import com.links.dao.entity.UserInfo;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Principal;
//
//@Controller
//@Log4j2
//public class UserController {
//
//    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model, @AuthenticationPrincipal UserInfo userInfo, Principal principal, HttpServletRequest servletRequest) {
//        try {
//            log.info(userInfo.getUsername());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            log.info(principal.getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            log.info(servletRequest.getUserPrincipal().getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "welcome";
//    }
//
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String userok(Model model) {
//        return "home";
//    }
//}
