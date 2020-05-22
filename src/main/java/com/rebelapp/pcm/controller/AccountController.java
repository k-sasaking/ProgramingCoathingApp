package com.rebelapp.pcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.entity.Category;
import com.rebelapp.pcm.service.CommonService;

@Controller
public class AccountController {

    @Autowired
    CommonService<Category,Long> commonService;

	
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {
        return "account/signin";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        return "account/signup";
    }
    
    @RequestMapping(value = "/password_change", method = RequestMethod.GET)
    public String password_change(Model model) {
        return "account/password_change";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        return "account/profile";
    }

    @RequestMapping(value = "/profile_edit", method = RequestMethod.GET)
    public String profile_form(Model model) {
    	
    	List<Category> categories = commonService.findAll();
    	model.addAttribute("categories", categories);

        return "account/profile_form";
    }
	
}