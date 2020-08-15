package com.rebelapp.pcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.config.Settings;
import com.rebelapp.pcm.entity.Category;
import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.form.ProductForm;
import com.rebelapp.pcm.service.CategoryService;
import com.rebelapp.pcm.service.ProductService;

@Controller
public class PostController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String detail(Model model) {
    	
    	List<Category> categories = categoryService.findAll();
    	model.addAttribute("categories", categories);
    	model.addAttribute("contact_tools", Settings.CONTACT_TOOLS.values());
    	model.addAttribute("contact_times", Settings.CONNTACT_DATE.values());
    	
        return "post/post_form";
    }
    
    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public String doDetail(Model model, @ModelAttribute("productForm") ProductForm productForm, BindingResult result) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(!auth.isAuthenticated())
    		return "error";
    	
    	if(result.hasErrors()) {
    		return "post/post_form";
    	}
    	
    	Integer userId = ((User) auth).getId();
    	productService.postProduct(userId, productForm);
		return "/";
    	
        
    }
    
    
    
	
}
