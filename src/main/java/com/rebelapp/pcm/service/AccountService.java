package com.rebelapp.pcm.service;

import java.util.Optional;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.form.SignupForm;

public interface AccountService {
	public Optional<User> getUser(String userName);

	public void signinUser(User user);

	public void signupUser(SignupForm signupForm);
	
	public void tokenRegister(SignupForm signupForm);
}