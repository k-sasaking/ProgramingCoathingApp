package com.rebelapp.pcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {
        return "account/signin";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        return "account/signup";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        return "account/profile";
    }

    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    public String profile_form(Model model) {
        return "account/profile_form";
    }
	
}
