package com.rebelapp.pcm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebelapp.pcm.entity.UserToken;
import com.rebelapp.pcm.form.SignupForm;

@Repository("confirmRepository")
public interface ConfirmTokenRepository extends JpaRepository<UserToken, String>{
	UserToken findByConfirmationToken(String confirmationToken);
	
	void save(SignupForm signupForm);
}