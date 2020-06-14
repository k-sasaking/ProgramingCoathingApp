package com.rebelapp.pcm.controller;

import com.rebelapp.pcm.entity.UserToken;
import com.rebelapp.pcm.form.SignupForm;
import com.rebelapp.pcm.repository.ConfirmTokenRepository;
import com.rebelapp.pcm.service.AccountServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Autowired
	MailSender mailsender;

    @Autowired
    ConfirmTokenRepository confirmTokenRepository;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignup(@Validated @ModelAttribute SignupForm signupForm, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "account/signup";
    	} else {
    	accountServiceImpl.signupUser(signupForm);
    	SimpleMailMessage mailMessage = new SimpleMailMessage();
    	mailMessage.setFrom("example.com");
    	mailMessage.setTo(signupForm.getEmail());
    	mailMessage.setSubject("Thank you for your registration");
    	mailMessage.setText("Dear " + signupForm.getUserName() + "\n" + "\n" + "Thank you for your registration to our coaching app. Let's dive into our community!!");
    	mailsender.send(mailMessage);
    	return "index";
    	}
    }
}

//        if (result.hasErrors()) {
//
//            model.addAttribute("postForm", signupForm);
//            return "signup";
//        } else {
//            //userRepository.save(signupForm);
//            //UserToken userToken = new UserToken();
//            //confirmTokenRepository.save(userToken);
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
////            mailMessage.setSubject("Confirm Your Account!");
////            mailMessage.setFrom("example.com");
////            mailMessage.setText("To confirm your account, please click here : "
////                    + "http://localhost:8080/confirm-account?token=" + userToken.getConfirmationToken());
////            javaMailSenderService.sendEmail(mailMessage);
//            mailMessage.setSubject("Confirm Your Account!");
//            mailMessage.setFrom("noreply@example.com");
//            mailMessage.setTo("yuusuke.phone.1018@gmail.com");
//            mailMessage.setText("testestsetesteststeststestesteststs");
//            mailSender.send(mailMessage);
//            return "index";
//            // 送信後の処理
////            model.addAttribute("emailId", signupForm.getUserName());
////            model.addAttribute("successfulRegisteration");
//        }


//    @RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
//    public String confirmUserAccount(Model model, @RequestParam("token") String confirmationToken) {
//        UserToken userToken = confirmTokenRepository.findByConfirmationToken(confirmationToken);
//        // トークン情報をUserインスタンスへ挿入
//        // 認証とユーザー情報の処理
//        if (userToken != null) {
//            User user = userRepository.findByEmail(userToken.getUser().getEmail());
//            userRepository.save(user);
//            model.addAttribute("accountVerified");
//        } else {
//            model.addAttribute("message", "The link is invalid or broken!");
//            model.addAttribute("error");
//        }
//
//        return "congratulations";
//    }
//    // getters and setters
//}
