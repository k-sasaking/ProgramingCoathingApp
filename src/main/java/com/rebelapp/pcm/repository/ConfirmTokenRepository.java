package com.rebelapp.pcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebelapp.pcm.entity.UserToken;

@Repository
public interface ConfirmTokenRepository extends JpaRepository<UserToken, String>{
	UserToken findByConfirmationToken(String confirmationToken);
}
