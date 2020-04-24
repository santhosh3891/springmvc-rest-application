package com.sample.spring.model;

public class Product {

	private int productId;
	private String productName;
	private String productDescription;
	private long productAmount;
	
	public Product(int productId, String productName, String productDescription, long productAmount) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productAmount = productAmount;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public long getProductAmount() {
		return productAmount;
	}
}
