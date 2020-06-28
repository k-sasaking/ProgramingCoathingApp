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
public class IndexController {

	@Autowired
	CategoryService categoryService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
    	
    	
        return "forward:/search";

    }
        	
}
