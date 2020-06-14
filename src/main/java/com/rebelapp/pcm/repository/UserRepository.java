package com.rebelapp.pcm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.form.SignupForm;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUsername(String username);


	void save(SignupForm signupForm);

	User findByEmail(String email);
}
