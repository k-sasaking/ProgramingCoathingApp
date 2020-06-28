package com.rebelapp.pcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

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

}