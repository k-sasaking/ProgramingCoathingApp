package com.rebelapp.pcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rebelapp.pcm.entity.Apply;
import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.form.ProductForm;
import com.rebelapp.pcm.repository.ProductRepository;
import com.rebelapp.pcm.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getSearchProducts(String word) {
		if (word == null || word.isEmpty())
			return productRepository.findAll();
		return productRepository.findByTitleLike("%" + word + "%");
	}

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Page<Product> getSearchProducts(Pageable pageable, String word) {

		if (word == null || word.isEmpty())
			return productRepository.findAll(pageable);
		return productRepository.findByTitleLike(pageable, "%" + word + "%");
	}

	@Override
	public Optional<Product> getSingleProduct(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public void postProduct(Integer userId, ProductForm productForm) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			return;
		}

		Product product = new Product(user.get(), productForm);
		productRepository.saveAndFlush(product);
	}
	

}
