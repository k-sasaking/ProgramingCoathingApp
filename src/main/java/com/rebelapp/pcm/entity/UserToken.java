package com.rebelapp.pcm.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "token_id")
	private long tokenid;
	
	@Column(name = "confirmationToken")
	private String confirmationToken;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "username")
	private User user;
	
	public void ConfirmationToken(User user) {
		this.user = user;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}

	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
