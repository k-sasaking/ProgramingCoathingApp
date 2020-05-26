package com.rebelapp.pcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebelapp.pcm.form.SignupForm;
import com.rebelapp.pcm.service.AccountService;


@Controller
public class SignUpController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String doSignup(Model model,
        @ModelAttribute("signupForm")
        @Validated
        SignupForm signupForm,
        BindingResult result) {
	if(result.hasErrors()) {

        model.addAttribute("postForm", signupForm);     
       return "signup";
    }

    accountService.signupUser(signupForm.getUser());
   return "redirect:/signin?username=" + signupForm.getUserName();
		
	}
}
