package com.rebelapp.pcm.service;

import java.util.List;

import com.rebelapp.pcm.entity.Favorite;

public interface FavoriteService {

	public void doFavorite(String username, Integer productId);

	public List<Favorite> getUserFavorite(String username);
	
}
