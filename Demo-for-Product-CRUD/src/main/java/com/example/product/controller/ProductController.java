package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		Product product = service.getProduct(id);
		return product;
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> products = service.getProducts();
		return products;
	}

	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {

		return service.saveProduct(product);
	}

	@DeleteMapping("/product/remove/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id) {

		 service.deleteProduct(id);
		 return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	

}
