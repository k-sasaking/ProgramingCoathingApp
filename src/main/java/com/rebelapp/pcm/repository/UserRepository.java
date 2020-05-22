package com.rebelapp.pcm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebelapp.pcm.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByUserName(String username);
}
