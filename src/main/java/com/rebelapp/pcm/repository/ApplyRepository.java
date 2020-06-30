package com.rebelapp.pcm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebelapp.pcm.entity.Apply;
import com.rebelapp.pcm.entity.User;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Integer> {

	List<Apply> findByUser(User user);
	
}
