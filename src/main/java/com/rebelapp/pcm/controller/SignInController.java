package com.rebelapp.pcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.form.SignInForm;
import com.rebelapp.pcm.service.AccountService;

@Controller
public class SignInController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin() {
		return "signin";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String doSignin(Model model,
	        @ModelAttribute("signupForm")
	        @Validated
	        SignInForm signinForm,
	        BindingResult result) {
		if(result.hasErrors()) {

            model.addAttribute("postForm", signinForm);     
           return "signin";
        }

        accountService.signinUser(signinForm.getUser());
       return "redirect:/signin?username=" + signinForm.getUsername();
	}
}
