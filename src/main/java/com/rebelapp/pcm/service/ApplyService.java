package com.rebelapp.pcm.service;


import java.util.Optional;
import java.util.List;

import com.rebelapp.pcm.entity.Apply;

public interface ApplyService {

	void sendApply(String username, Integer productId, String message);

	List<Apply> getUserApplies(String username);
	

}
