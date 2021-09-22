package com.example.product.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO class for Product
 * 
 * @author home
 * @version 1.0
 */
public class ProductDTO {

	public ProductDTO(String string, double d) {
		this.productname = string;
		this.productrate = d;
	}

	@NotNull(message = "Please enter product name")
	@NotBlank(message = "Field should not be blank")
	@Size(min = 1, max = 500, message = "Please enter values between 1 to 500")
	private String productname;

	@NotNull(message = "Please enter product rate")
	private Double productrate;

	public ProductDTO() {
		super();

	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getProductrate() {
		return productrate;
	}

	public void setProductrate(Double productrate) {
		this.productrate = productrate;
	}

	@Override
	public String toString() {
		return "ProductDTO [productname=" + productname + ", productrate=" + productrate + "]";
	}

}
