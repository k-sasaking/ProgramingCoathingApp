package com.rebelapp.pcm.form;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.validation.ExistUserName;
import com.rebelapp.pcm.validation.PasswordConfirm;


@PasswordConfirm(password = "password", confirmPassword = "confirmPassword")
@SuppressWarnings("serial")
public class SignupForm implements Serializable{
	
	@ExistUserName
	@NotNull
	@NotEmpty(message = "名前を入力してください")
	private String userName;
	
	@Email
	@NotNull(message = "メールアドレスを入力してください")
	@NotEmpty(message = "メールアドレスを入力してください")
	private String email;
	
	@NotNull
	@NotEmpty(message = "パスワードを入力してください")
	@Size(min = 6, max = 32)
	private String password;
	
	@NotNull
	@NotEmpty
	private String confirmPassword;
	
	public User getUser() {
        return new User();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
