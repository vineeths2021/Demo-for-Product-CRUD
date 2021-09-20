package com.example.product.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;

import com.example.product.repository.ProductRepository;
/**
Service Implementation
*/
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product getProduct(String id) {

		return repository.findById(Long.valueOf(id)).orElseThrow(() -> new EntityNotFoundException((id)));
	}

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public void deleteProduct(String id) {
		Product product=repository.findById(Long.valueOf(id)).orElseThrow(() -> new EntityNotFoundException((id)));
		repository.delete(product);
	}
}
