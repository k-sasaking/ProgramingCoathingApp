package com.rebelapp.pcm.form;

import javax.validation.constraints.NotNull;

public class ApplyForm {
	
	@NotNull
	private String message;
	private String username;
	private Integer productId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
