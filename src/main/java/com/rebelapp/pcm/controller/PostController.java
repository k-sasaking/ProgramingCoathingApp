package com.rebelapp.pcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.config.Settings;
import com.rebelapp.pcm.entity.Category;
import com.rebelapp.pcm.service.CommonService;

@Controller
public class PostController {

    @Autowired
    CommonService<Category,Long> commonService;
	
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String detail(Model model) {
    	
    	List<Category> categories = commonService.findAll();
    	model.addAttribute("categories", categories);
    	model.addAttribute("contact_tools", Settings.CONTACT_TOOLS.values());
    	model.addAttribute("contact_times", Settings.CONNTACT_DATE.values());
    	
        return "post/post_form";
    }
	
}
