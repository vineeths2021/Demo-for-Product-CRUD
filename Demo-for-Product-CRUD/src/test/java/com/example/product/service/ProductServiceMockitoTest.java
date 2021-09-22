package com.example.product.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

/**
 * Service Layer unit testcases with Mockito
 * @author Vineeth
 *
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceMockitoTest {
	
	
	@InjectMocks
	private ProductService service=new ProductService();
	
	@Mock
	private ProductRepository repository;
	

	
	@DisplayName(" Product save Success")
	@Test
	public void testSaveProductServiceSuccess(){
		//create a product
		Product product=new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		
		
		when(repository.save(any(Product.class))).thenReturn(product);
		
		//save the product
		Product newProduct=service.saveProduct(product);
		
		//verify the save
		assertEquals("Car",newProduct.getProductname());
	}
	
	@DisplayName(" Product get Success")
	@Test
	public void testGetProductServiceSuccess(){
		
		String id="1";
		//create a product
		Product product=new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		Optional<Product> returnProduct = Optional.of((Product) product);
		
		when(repository.findById(Long.valueOf(id))).thenReturn(returnProduct);
		
		//save the product
		Product newproduct=service.getProduct(id);
		
		//verify the save
		assertEquals("Car",newproduct.getProductname());
	}
	
	@DisplayName(" Product get All Success")
	@Test
	public void testGetAllProductServiceSuccess(){
		
		
		//create a product
		Product product=new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		List<Product> returnProduct = new ArrayList();
		returnProduct.add(product);
		when(repository.findAll()).thenReturn(returnProduct);
		
		//save the product
		List<Product> newproductlist=service.getProducts();
		
		//verify the save
	
		 assertEquals(1, newproductlist.size());
	}
	@DisplayName(" Product delete Success")
	@Test
	public void testdeleteProductServiceSuccess(){
		
		
		//create a product
		Product product=new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		List<Product> returnProduct = new ArrayList();
		returnProduct.add(product);
		when(repository.findAll()).thenReturn(returnProduct);
		
		//save the product
		List<Product> newproductlist=service.getProducts();
		
		//verify the save
	
		 assertEquals(1, newproductlist.size());
	}
}
