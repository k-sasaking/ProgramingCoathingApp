package com.rebelapp.pcm.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.service.ProductService;

@Controller
public class SearchController {


    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Model model) {
    	return "search/detail";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String index(
    		Model model,
    		@PageableDefault(page = 0, size = 10) 
            Pageable pageable,
            @RequestParam(name = "query", required = false)
            String searchWord
            ) {
    
    	Page<Product> products = productService.getSearchProducts(pageable, searchWord);
    	System.out.println(products.getSize());
        	
    	model.addAttribute("message", "This is sample page");   
    	model.addAttribute("products", products); 

       return "index";
    
    }
}
