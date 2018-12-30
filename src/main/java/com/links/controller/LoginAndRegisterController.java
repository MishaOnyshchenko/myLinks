package com.links.controller;



import com.links.dao.entity.UserInfo;
import com.links.service.SecurityService;
import com.links.service.UserService;
import com.links.validator.UserValidator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAndRegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userInfoForm", new UserInfo());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userInfoForm") UserInfo userInfoForm, BindingResult bindingResult) {
        userValidator.validate(userInfoForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        System.out.println("-----------!!!!! UserInfoForm will be sent to userService: " + userInfoForm.getUsername() + "+ passConfirm: " + userInfoForm.getPasswordConfirm());

        userService.save(userInfoForm);

        securityService.autologin(userInfoForm.getUsername(), userInfoForm.getPasswordConfirm());

        return "add";
    }
}
