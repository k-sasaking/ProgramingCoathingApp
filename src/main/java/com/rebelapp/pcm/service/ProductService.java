package com.rebelapp.pcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.form.ProductForm;

public interface ProductService {

    public Optional<Product> getSingleProduct(Integer id);

    public List<Product> getAllProducts();

    public Page<Product> getAllProducts(Pageable pageable);

    public List<Product> getSearchProducts(String word);

    public Page<Product> getSearchProducts(Pageable pageable, String word);

	public void postProduct(Integer userId, ProductForm productForm);
}