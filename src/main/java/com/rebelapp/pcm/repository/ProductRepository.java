package com.rebelapp.pcm.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rebelapp.pcm.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();
    Page<Product> findAll(Pageable pageable); 
    List<Product> findByTitleLike(String word); 
    Page<Product> findByTitleLike(Pageable pageable, String word); 

}