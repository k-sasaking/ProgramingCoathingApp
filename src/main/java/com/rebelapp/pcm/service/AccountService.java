package com.rebelapp.pcm.service;

import java.util.Optional;

import com.rebelapp.pcm.entity.User;

public interface AccountService {
	public Optional<User> getUser(String userName);
	
	public void signinUser(User user);
}