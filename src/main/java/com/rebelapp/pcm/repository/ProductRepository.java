package com.rebelapp.pcm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rebelapp.pcm.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(Integer id);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    List<Product> findByTitleLike(String word);

    Page<Product> findByTitleLike(Pageable pageable, String word);
}
