package com.rebelapp.pcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailSenderService {

	private JavaMailSender JavaMailSender;
 
	@Autowired
	public JavaMailSenderService(JavaMailSender JavaMailSender) {
		this.JavaMailSender = JavaMailSender;
	}

	public void sendEmail(SimpleMailMessage email) {
		JavaMailSender.send(email);
	}

}
