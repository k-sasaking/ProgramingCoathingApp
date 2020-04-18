package com.rebelapp.pcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.entity.Category;
import com.rebelapp.pcm.service.CommonService;

@Controller
public class IndexController {

    @Autowired
    CommonService<Category,Long> commonService;
	
	@Autowired
	   JdbcTemplate jdbcTemplate;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
    	
    	List<Category> categories = commonService.findAll();
    	model.addAttribute("categories", categories);
    	
        return "index";

    }
        	
}
