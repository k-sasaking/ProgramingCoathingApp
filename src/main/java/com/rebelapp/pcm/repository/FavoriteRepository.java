package com.rebelapp.pcm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebelapp.pcm.entity.Favorite;
import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.entity.User;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	List<Favorite> findByUserAndProduct(User user, Product product);
	List<Favorite> findByUser(User user);

}
