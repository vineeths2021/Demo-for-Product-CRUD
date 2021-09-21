package com.example.product.models;

public class ProductDTO {

	public ProductDTO(String string, double d) {
		this.productname=string;
		this.productrate=d;
	}

	private String productname;

	private double productrate;

	public ProductDTO() {
		super();
	
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductrate() {
		return productrate;
	}

	public void setProductrate(double productrate) {
		this.productrate = productrate;
	}
	
	
}
