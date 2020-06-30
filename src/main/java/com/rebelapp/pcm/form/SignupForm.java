package com.rebelapp.pcm.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.validation.PasswordConfirm;



@PasswordConfirm(password = "password", confirmPassword = "confirmPassword")
public class SignupForm {
	
	@Email
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	private String confirmPassword;
	
	public User getUser() {
        return new User(this.username, this.password);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
