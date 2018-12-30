package com.links.controller;

import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.service.LinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/show")
public class AddController {

    static final Logger log = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private LinkService linkService;


    @RequestMapping()
    public String showPage(Model model) {
        model.addAttribute("message", "Your bookmarks");

        List<LinkEntity> links = linkService.allLinks();
        model.addAttribute("links", links);

        List<CategoryEntity> categories = linkService.allCategories();
        model.addAttribute("categories", categories);

        return "add";
    }


    @RequestMapping(value = "/add/link")
    public String addLink(@ModelAttribute LinkEntity linkEntity, @RequestParam ("category") String category) {
        log.info("Category received from client for saving new link and will be sent to service: " + category);

        System.out.println();
        linkService.addLink(linkEntity, category);
        log.info("LinkEntity was sent to service from controller: " + linkEntity);

        return "redirect:/show";
    }


    @RequestMapping(value = "/category/links")
    public String getLinksByCategory(@RequestParam ("category") String category, Model model) {
        log.info("Client asked to show all links by category: " + category);

        List<LinkEntity> linksFromChosenCategory = linkService.showLinksByCategory(category);
        log.info("Next links from chosen category received from service: " + linksFromChosenCategory);

        model.addAttribute("message3", "Your links in category " + category);
        model.addAttribute("linksFromChosenCategory", linksFromChosenCategory);

        return "category";
    }


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
