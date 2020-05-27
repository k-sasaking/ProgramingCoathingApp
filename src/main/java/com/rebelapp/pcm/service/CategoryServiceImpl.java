package com.rebelapp.pcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebelapp.pcm.entity.Category;
import com.rebelapp.pcm.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}
