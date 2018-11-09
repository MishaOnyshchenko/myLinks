//package com.links.controller;
//
//import com.bookmark.service.dao.model.MenuTittle;
//import com.bookmark.service.service.impl.MenuTittleServiceIml;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.security.Principal;
//
//@Controller
//@RequestMapping("/private/menu")
//public class CategoryController {
//    @Autowired
//    private MenuTittleServiceIml menuTittleServiceIml;
//
//    @GetMapping("/add")
//    private String addMenu(Model model) {
//        model.addAttribute("menuTittle", new MenuTittle());
//        return "addMenu";
//    }
//
//    @PostMapping("/add")
//    private String addMenu(@RequestParam("tittle") String tittle, @RequestParam("subGroup") String subGroup, Principal principal) {
//        System.out.println(tittle);
//        menuTittleServiceIml.saveMenu(tittle, subGroup, principal.getName());
//        return "redirect:/private/menu/add";
//    }
//
//    @PostMapping("/addBookmark")
//    private String addBookmark(@RequestParam("shortDescription") String shortDescription,
//                               @RequestParam("link") String link,
//                               @RequestParam("tittle") String tittle,
//                               @RequestParam("currentTittle") String currentTittle,
//                               Principal principal) {
//        System.out.println("+++++++++++++");
//        System.out.println(link);
//        System.out.println(shortDescription);
//        System.out.println(tittle);
//        System.out.println(currentTittle);
//        System.out.println("+++++++++++");
//        String redirectUrl = "redirect:/private/home/" + currentTittle;
//        menuTittleServiceIml.saveBookMark(principal.getName(), tittle, link, shortDescription, currentTittle);
//        return redirectUrl;
//    }
//}
