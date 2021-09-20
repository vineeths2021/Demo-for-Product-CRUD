package com.example.product.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

	@Autowired
	MockMvc mockmvc;

	@MockBean
	private ProductService service;
	
	@Test
	@DisplayName("Getting a Product Success response")
	public void getProductTest() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.get("/api/product/{id}", 1)).andExpect(status().is2xxSuccessful());
	}

	@Test
	@DisplayName("Getting a Product List Success response")
	public void getProductsTest() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.get("/api/products")).andExpect(status().isOk());
	}

	@Test
	@DisplayName("Saving a Product List Success response")
	public void saveProductTest() throws Exception {

		 mockmvc.perform(MockMvcRequestBuilders
				.post("/api/product")
				.content(asJsonString(new Product("firstName4", 12.0)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
			    .andExpect(MockMvcResultMatchers.jsonPath("$.productid").exists());
				
	}
	@Test
	@DisplayName("delete a Product Success response")
	public void deleteEmployeeAPI() throws Exception 
	{
	  mockmvc.perform( MockMvcRequestBuilders.delete("/api/product/remove/{id}", 1) )
	        .andExpect(status().isAccepted());
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}