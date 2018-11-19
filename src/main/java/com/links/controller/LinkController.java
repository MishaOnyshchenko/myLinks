package com.links.controller;

import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class LinkController {

    @Autowired
    private LinkService linkService;


    @RequestMapping
    public String showWelcome(Model model) {
        List<LinkEntity> links = linkService.allLinks();
        model.addAttribute("links", links);

        model.addAttribute("message", "Welcome to myLinks");

        List<CategoryEntity> categories = linkService.allCategories();
        model.addAttribute("categories", categories);

        return "view/welcome";
    }


    @RequestMapping(value = "go")
    public String show() {
        return "redirect:/show";
    }


}
