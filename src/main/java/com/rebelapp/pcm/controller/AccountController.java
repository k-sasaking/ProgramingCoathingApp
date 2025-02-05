package com.rebelapp.pcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.entity.Category;
import com.rebelapp.pcm.service.CategoryService;

@Controller
public class AccountController {

	@Autowired
	CategoryService categoryService;

	
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {
        return "account/signin";
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
    	
    	List<Category> categories = categoryService.findAll();
    	model.addAttribute("categories", categories);

        return "account/profile_form";
    }
	
}