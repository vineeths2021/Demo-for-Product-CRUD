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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;


@SpringBootTest
public class ProductServiceIntegrationTest {
	
	
	@InjectMocks
	private ProductService service=new ProductService();
	
	@Mock
	private ProductRepository repository;
	
	/*@DisplayName(" Product save Success")
	@Test
	public void testSaveProductSuccess(){
		//create a product
		Product product=new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		
		
		when(repository.save(any(Product.class))).thenReturn(product);
		
		//save the product
		Product newProduct=service.saveProduct(null);
		
		//verify the save
		assertEquals("Car",newProduct.getProductname());
	}*/

}
