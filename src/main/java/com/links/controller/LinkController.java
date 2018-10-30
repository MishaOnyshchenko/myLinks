package com.links.controller;

import com.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class LinkController {

    @Autowired
    private LinkService linkService;


    @RequestMapping(method = RequestMethod.GET)
    public String showWelcome(Model model) {

        ArrayList<String> links = linkService.allLinks();

        model.addAttribute("links", links);
        model.addAttribute("message", "Welcome to myLinks");

        return "welcome";
    }


    @RequestMapping(value = "go", method = RequestMethod.GET)
    public String show(Model model) {

        model.addAttribute("message", "It's a showtime");

        return "redirect:/show";
    }
}
