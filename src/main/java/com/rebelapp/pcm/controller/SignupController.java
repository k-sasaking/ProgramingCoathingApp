package com.rebelapp.pcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
public class SignupController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(
			Model model,
			@ModelAttribute("signupForm")
			SignupForm signupForm
			) {
		model.addAttribute("signupForm",signupForm);
		return "account/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String doSignup(Model model,
        @ModelAttribute("signupForm")
        @Validated
        SignupForm signupForm,
        BindingResult result
        ) {
		
		if(result.hasErrors()) {
	        model.addAttribute("signupForm", signupForm);     
	       return "account/signup";
	    }
		
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setSubject("Confirm Your Account!");
//        mailMessage.setFrom("example@");
//        mailMessage.setText("testestsetesteststeststestesteststs");
//        mailSender.send(mailMessage);

       // 送信後の処理
	   accountService.signupUser(signupForm.getUser());
	   return "redirect:/signin?username=" + signupForm.getUsername();
		
	}
	
	@RequestMapping(value="/mail", method=RequestMethod.GET)
	public String sendMail(Model model) {
		
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Confirm Your Account!");
        mailMessage.setFrom("noreply@example.com");
        mailMessage.setTo("tanuking.ponta@gmail.com");
        mailMessage.setText("testestsetesteststeststestesteststs");
        mailSender.send(mailMessage);
        
        return "index";
		
	}

}
