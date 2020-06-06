package com.rebelapp.pcm.controller;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.entity.UserToken;
import com.rebelapp.pcm.form.SignupForm;
import com.rebelapp.pcm.repository.ConfirmTokenRepository;
import com.rebelapp.pcm.repository.UserRepository;
import com.rebelapp.pcm.service.JavaMailSenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfirmTokenRepository confirmTokenRepository;

    @Autowired
    JavaMailSenderService javaMailSenderService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignup(Model model, @ModelAttribute("signupForm") @Validated SignupForm signupForm,
            BindingResult result) {
        if (result.hasErrors()) {

            model.addAttribute("postForm", signupForm);
            return "signup";
        } else {
            userRepository.save(signupForm);
            UserToken userToken = new UserToken();
            confirmTokenRepository.save(userToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject("Confirm Your Account!");
            mailMessage.setFrom("rebelapp@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + userToken.getConfirmationToken());
            javaMailSenderService.sendEmail(mailMessage);

            // 送信後の処理
            model.addAttribute("emailId", signupForm.getUserName());
            model.addAttribute("successfulRegisteration");
        }

        return "/";
    }

    @RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
    public String confirmUserAccount(Model model, @RequestParam("token") String confirmationToken) {
        UserToken userToken = confirmTokenRepository.findByConfirmationToken(confirmationToken);
        // トークン情報をUserインスタンスへ挿入
        // 認証とユーザー情報の処理
        if (userToken != null) {
            User user = userRepository.findByEmail(userToken.getUser().getEmail());
            userRepository.save(user);
            model.addAttribute("accountVerified");
        } else {
            model.addAttribute("message", "The link is invalid or broken!");
            model.addAttribute("error");
        }

        return "congratulations";
    }
    // getters and setters
}
