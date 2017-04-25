package com.emusicstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	private int productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private String productCondition;
	private String productStatus;
	private double productPrice;
	private int productUnitInStock;
	private String productManufacturer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductUnitInStock() {
		return productUnitInStock;
	}
	public void setProductUnitInStock(int productUnitInStock) {
		this.productUnitInStock = productUnitInStock;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	
	
}
