package com.rebelapp.pcm.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class ProductForm {
	
	
	@NotNull(message = "カテゴリーを選んでください")
	private String category;
	
	@NotBlank(message = "タイトルを入力してください")
	private String title;
	
	@NotBlank(message = "説明を入力してください")
	private String description;
	
	@NotBlank(message = "料金を入力してください")
	private Integer price;
	
	@NotNull(message = "時間を選んでください")
	private String time;
	
	@NotNull(message = "コンタクトツールを選んでください")
	private String ContactTools;
	
	private boolean isPublished;
	
	void PostForm(){
		this.isPublished = false;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContactTools() {
		return ContactTools;
	}

	public void setContactTools(String contactTools) {
		ContactTools = contactTools;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

}
