package com.rebelapp.pcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebelapp.pcm.entity.Apply;
import com.rebelapp.pcm.entity.Favorite;
import com.rebelapp.pcm.entity.Product;
import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.repository.ApplyRepository;
import com.rebelapp.pcm.repository.ProductRepository;
import com.rebelapp.pcm.repository.UserRepository;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ApplyRepository applyRepository;

	
	@Override
	public void sendApply(String username, Integer productId, String message) {

		Optional<User> user = userRepository.findByUsername(username);
		Optional<Product> product = productRepository.findById(productId);
		
		if(user.isEmpty() || product.isEmpty())
			return;

		Apply apply = new Apply(user.get(), product.get(), message);
		applyRepository.saveAndFlush(apply);
		
	}


	@Override
	public List<Apply> getUserApplies(String username) {
		
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isEmpty())
			return null;
		return applyRepository.findByUser(user.get());
	}

}
