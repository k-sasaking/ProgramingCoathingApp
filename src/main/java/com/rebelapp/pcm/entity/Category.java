package com.rebelapp.pcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CATEGORY")
public class Category {

    /* Columnの定義 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column(name = "category_name", length = 30)
    @NotEmpty
    private String category_name;
    
    @Column(name = "category_image", length = 255)
    @NotNull
    private String category_image;
    
    public String getCategoryName() {
    	return this.category_name;
    }
    
    public String getCategoryImage() {
    	return this.category_image;
    }

}

