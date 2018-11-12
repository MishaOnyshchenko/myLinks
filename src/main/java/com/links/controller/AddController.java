package com.links.controller;


import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.service.LinkService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/show")
public class AddController {

    @Autowired
    private LinkService linkService;


    @RequestMapping()
    public String showPage(Model model) {
        model.addAttribute("message", "Your bookmarks");
        List<LinkEntity> links = linkService.allLinks();
        model.addAttribute("links", links);

        model.addAttribute("message2", "Your bookmarks sorted by the next categories");
        List<CategoryEntity> categories = linkService.allCategories();
        model.addAttribute("categories", categories);

        return "/add";
    }


    @RequestMapping(value = "/add/link")
    public String addLink(@ModelAttribute LinkEntity linkEntity, @RequestParam ("category") String category) {

        System.out.println("********!!!!!!!!!!!!!Category received***********!!!!!!!!!!!!!!! " + category);
        linkService.addLink(linkEntity, category);
        System.out.println("!!!SENT to SERVICE for SAVING!!!!!!!! " + linkEntity);

        return "redirect:/show";
    }

    @RequestMapping(value = "/category/links")
    public String getLinksByCategory(@RequestParam ("category") String category, Model model) {
        System.out.println("********Links by Category received***********!!!!!!!!!!!!!!! " + category);
        List<LinkEntity> linksFromChosenCategory = linkService.showLinksByCategory(category);
        System.out.println("********List of the Links received from service***********!!!!!!!!!!!!!!! " + linksFromChosenCategory);

        model.addAttribute("message3", "Your links in category " + category);
        model.addAttribute("linksFromChosenCategory", linksFromChosenCategory);

        return "/category";
//        return "redirect:/show";
    }



//    @RequestMapping(value = "/category/links")
//    public String getLinksByCategory(Model model) {
//        model.addAttribute("message3", "!!!! Bookmarks by the category ");
//        return "/add";
//    }

//    @RequestMapping(value = "/category/links/show")
//    public String showLinksByCategory(Model model) {
//        System.out.println("********Links by Category received***********!!!!!!!!!!!!!!! " + category);
//        List<LinkEntity> linksFromChosenCategory = linkService.showLinksByCategory(category);
//        System.out.println("********List of the Links received from service***********!!!!!!!!!!!!!!! " + linksFromChosenCategory);
//
//        model.addAttribute("linksFromChosenCategory", linksFromChosenCategory);
//
//        return "redirect:/show";
//    }



    @RequestMapping(value = "/add/category")
    public String addCategory(@ModelAttribute CategoryEntity category) {
        linkService.addCategory(category);
        return "redirect:/show";
    }


    @RequestMapping(value = "/del/link")
    public String deleteLink(@ModelAttribute LinkEntity linkEntity) {
        linkService.deleteLink(linkEntity);
        return "redirect:/show";
    }

    @RequestMapping(value = "/del/category")
    public String deleteCategory(@ModelAttribute CategoryEntity categoryEntity) {
        linkService.deleteCategory(categoryEntity);
        return "redirect:/show";
    }

}
