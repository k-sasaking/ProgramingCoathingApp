package com.rebelapp.pcm.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rebelapp.pcm.entity.Product;

public interface ProductService {

    public List<Product> getAllProducts();
    public List<Product> getSearchProducts(String word);
    public Page<Product> getAllProducts(Pageable pageable);
    public Page<Product> getSearchProducts(Pageable pageable, String word);

}
