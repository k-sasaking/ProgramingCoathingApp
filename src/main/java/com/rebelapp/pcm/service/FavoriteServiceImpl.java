package com.rebelapp.pcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebelapp.pcm.entity.Favorite;
import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.repository.FavoriteRepository;
import com.rebelapp.pcm.repository.ProductRepository;
import com.rebelapp.pcm.repository.UserRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;
	
	@Override
	public void doFavorite(String username, Integer productId) {
		
		Optional<User> user = userRepository.findByUsername(username);
		Optional<Product> product = productRepository.findById(productId);
		
		if (!user.isPresent() || !product.isPresent())
			return;
		
		List<Favorite> fav = favoriteRepository.findByUserAndProduct(user.get(), product.get());
		if(fav.isEmpty()) {
			
			Favorite newfav = new Favorite(user.get(), product.get());
			favoriteRepository.saveAndFlush(newfav);
			
		} else {
			favoriteRepository.delete(fav.get(0));
		}
		

	}

	@Override
	public List<Favorite> getUserFavorite(String username) {
		
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isEmpty())
			return null;
		List<Favorite> favorits = favoriteRepository.findByUser(user.get());
		return favorits;
	}

}
