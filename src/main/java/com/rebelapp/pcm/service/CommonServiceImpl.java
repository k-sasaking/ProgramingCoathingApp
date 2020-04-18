package com.rebelapp.pcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class CommonServiceImpl<T,ID> implements CommonService<T,ID> {
		
    @Autowired
    private JpaRepository<T,ID> jpaRepository;
    
	@Override
	public List<T> findAll() {
		return jpaRepository.findAll();
	}

}
