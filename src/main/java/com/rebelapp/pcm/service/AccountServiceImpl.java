package com.rebelapp.pcm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.entity.UserDetailsImpl;
import com.rebelapp.pcm.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public AccountServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return new UserDetailsImpl(user.get(), null);
		} else {
			throw new UsernameNotFoundException("user not found");
		}
	}

	@Override
	public Optional<User> getUser(String userName) {

		return userRepository.findByUsername(userName);
	}
	
	@Override
	public void signupUser(User user) {
		String encodedPassword = passwordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.saveAndFlush(user);	
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
