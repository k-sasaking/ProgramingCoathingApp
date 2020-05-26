package com.rebelapp.pcm.service;


import java.util.Optional;

import com.rebelapp.pcm.entity.User;

public interface AccountService {
	public void signupUser(User user);

	public Optional<User> getUser(String value);
}
