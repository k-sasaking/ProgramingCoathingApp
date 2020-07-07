package com.rebelapp.pcm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rebelapp.pcm.form.ProductForm;


@Entity
@Table(name = "PRODUCT")
public class Product {

    /* Columnの定義 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    
    private Integer price;

    @Column(name = "contact_tools")
    
    private String ContactTools;
    
    @Column(name = "time")
    
    private String time;
    
    @Column(name = "category")
    
    private String category;
    
    @Column(name = "description")
    
    private String description;
    
    @Column(name = "rating")
    
    private Integer rating;
     
    @Column(name = "is_published")
    
    private boolean isPublished;
     
    @Column(name = "created_at")
    
    private Date createdAt;
    
    @Column(name = "updated_at")
    
    private Date updatedAt;
    
    public Product() {
    	
    }
    
    public Product(User user) {
    	this.user = user;
	}
    
    public Product(User user, ProductForm productForm) {
    	this(user);
        this.category = productForm.getCategory();
        this.title = productForm.getTitle();
    	this.description = productForm.getDescription();
    	this.price = productForm.getPrice();
    	this.time = productForm.getTime();
    	this.ContactTools = productForm.getContactTools();
        this.isPublished = productForm.isPublished();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getContactTools() {
		return ContactTools;
	}

	public void setContactTools(String contactTools) {
		ContactTools = contactTools;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	} 
	

}