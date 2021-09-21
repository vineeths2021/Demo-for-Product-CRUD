package com.example.product.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.exception.ResourceNotFoundException;
import com.example.product.repository.ProductRepository;
/**
Service Implementation
*/
@Service
public class ProductService {
	private static final Logger logger = LogManager.getLogger(ProductService.class);
	@Autowired
	private ProductRepository repository;

	public Product getProduct(String id) {
		logger.info("getProduct() Service method invoked");
		return repository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Not found with id"+id));
	}

	public Product saveProduct(Product product) {
		logger.info("saveProduct() Service method invoked");
		return repository.save(product);
	}

	public List<Product> getProducts() {
		logger.info("getProducts() Service method invoked");
		return repository.findAll();
	}

	public void deleteProduct(String id) {
		logger.info("deleteProduct() Service method invoked");
		Product product=repository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Not found with id"+id));
		repository.delete(product);
	}
}
