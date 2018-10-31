package com.links.controller;


import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/show")
public class AddController {

    @Autowired
    private LinkService linkService;


    @RequestMapping(method = RequestMethod.GET)
    public String showPage(Model model) {
        model.addAttribute("message", "It's a showtime");

        List<LinkEntity> links = linkService.getLinkEntityList();
        model.addAttribute("links", links);

        List<CategoryEntity> categories = linkService.getCategoryEntityList();
        model.addAttribute("categories", categories);

        return "/add";
    }


    @RequestMapping(value = "/add/link", method = RequestMethod.GET)
    public String addLink(@ModelAttribute LinkEntity linkEntity) {

        linkService.addLink(linkEntity);

        return "redirect:/show";
    }

    @RequestMapping(value = "/add/category", method = RequestMethod.GET)
    public String addCategory(@ModelAttribute CategoryEntity categoryEntity) {

        linkService.addCategory(categoryEntity);

        return "redirect:/show";
    }


    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String delete(@ModelAttribute LinkEntity linkEntity) {

        linkService.deleteLink(linkEntity);

        return "redirect:/show";
    }

}
