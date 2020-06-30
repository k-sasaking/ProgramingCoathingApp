package com.rebelapp.pcm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebelapp.pcm.service.FavoriteService;


@Controller
public class FavoriteController {

		@Autowired
		FavoriteService favoriteService;
	
	   @RequestMapping(value = "/favorite/{productId}", method = RequestMethod.GET)
	   @ResponseBody
	   public String[] doFavorite(
			   @PathVariable Integer productId,
			   @RequestParam(name = "username", required = true)
	            String username
			   ) {

	       String[] result = { "error" };
	       
	       favoriteService.doFavorite(username, productId);
           result[0] = "success";

	       return result;
	   }
        	
}
