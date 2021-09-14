package com.pairlearning.expensetracker.domain;

public class Product {

    private Integer id;
    private Integer catId;
    private String name;
    private String brand;
    private String description;
    private Double price;
    private Integer discount;
	public Product(Integer id, Integer catId, String name, String brand, String description, Double price,
			Integer discount) {
		super();
		this.id = id;
		this.catId = catId;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

    
}
