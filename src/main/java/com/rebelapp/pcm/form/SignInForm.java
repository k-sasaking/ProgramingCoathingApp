package com.rebelapp.pcm.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rebelapp.pcm.entity.User;

public class SignInForm {
	
	
	private String username;
	
	@Size(min = 8, max=16, message="パスワードは{min}文字以上{max}文字以下です。" )
	@Pattern(regexp="[a-zA-Z0-9]*", message="パスワードは英数である必要があります。")
	@NotBlank
	private String password;
	
	public User getUser() {
        return new User();
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
	
	
}
