package com.example.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Table(name="TBL_PRODUCT")
@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="productid")
	private Long productid;
	
	@Column(name ="product_name")
	private String productname;
	
	@Column(name ="product_rate")
	private double productrate;
    public Product(){}

	public Product(String productname, double productrate) {
		super();
		this.productname = productname;
		this.productrate = productrate;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
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
