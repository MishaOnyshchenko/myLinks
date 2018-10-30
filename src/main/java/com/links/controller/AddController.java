package com.links.controller;


import com.links.dao.entity.LinkEntity;
import com.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/show")
public class AddController {

    @Autowired
    private LinkService linkService;


    @RequestMapping(method = RequestMethod.GET)
    public String showPage(Model model) {

        List<LinkEntity> links = linkService.linkEntityList();
        model.addAttribute("links", links);

        return "/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute LinkEntity linkEntity) {

        linkService.addLink(linkEntity);

        System.out.print(linkEntity.getName() + " " + linkEntity.getAddress());
        return "redirect:/show";
    }


//    @RequestMapping(value = "/delAll", method = RequestMethod.GET)
//    public String deleteAll(@ModelAttribute LinkEntity linkEntity) {
//        ArrayList<String> links = linkService.allLinks();
//        links.clear();
//        return "redirect:/show";
//    }


//    @RequestMapping(value = "/del", method = RequestMethod.GET)
//    public String delete(@ModelAttribute LinkEntity linkEntity) {
//        ArrayList<String> links = linkService.allLinks();
//        links.remove(linkEntity.getName());
//        System.out.println(linkEntity.getName());
//        return "redirect:/show";
//    }
}
