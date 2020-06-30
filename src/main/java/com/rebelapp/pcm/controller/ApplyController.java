package com.rebelapp.pcm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.entity.Favorite;
import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.form.ApplyForm;
import com.rebelapp.pcm.form.SignupForm;
import com.rebelapp.pcm.service.ApplyService;
import com.rebelapp.pcm.service.ProductService;

@Controller
public class ApplyController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "/apply/{productId}", method = RequestMethod.GET)
    public String detail(
			Model model,
		    @PathVariable Integer productId,
			@ModelAttribute("applyForm")
			ApplyForm applyForm
    		) {
    	
    	Optional<Product> product = productService.getSingleProduct(productId);
    	if(product.isEmpty())
    		return "error";
    	
    	model.addAttribute("product", product.get());     
        model.addAttribute("applyForm", applyForm);     
        return "apply/apply_form";
    }
	

    @RequestMapping(value = "/apply/doApply/{productId}", method = RequestMethod.POST)
    public String detail(
			Model model,
		    @PathVariable Integer productId,
	        @Validated
			@ModelAttribute("applyForm")
			ApplyForm applyForm,
	        BindingResult result

    		) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
    	if(!auth.isAuthenticated())
    		return "error";
    	
        if(result.hasErrors()) {
	        model.addAttribute("applyForm", applyForm);     
	        return "apply/apply_form";
	    }
		
        String username = auth.getName();
        
        applyService.sendApply(username, productId, applyForm.getMessage());
		
		
	   return "redirect:/";
    	
    }
	
}
