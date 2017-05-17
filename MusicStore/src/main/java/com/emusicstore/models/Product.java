package com.emusicstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	private int productId;
	@NotEmpty(message = "product name cannot be empty.")
	private String productName;
	private String productCategory;
	@NotEmpty(message = "please give some description about the product.")
	private String productDescription;
	private String productCondition;
	private String productStatus;
	@Min(value = 0, message = "product price cannot be less then 0.")
	private double productPrice;
	@Min(value = 0, message = "prouduct stock cannot be less then 0.")
	private int productUnitInStock;
	@NotEmpty(message = "product manufacturer name is necessary.")
	private String productManufacturer;
	
	@NotNull(message = "please upload product image.")
	private MultipartFile productImage;
	
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
	
	@Transient
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}	
	
}
