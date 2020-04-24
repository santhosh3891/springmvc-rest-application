package com.sample.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.constants.Constants;
import com.sample.spring.model.Configuration;
import com.sample.spring.model.Configurations;
import com.sample.spring.model.Product;
import com.sample.spring.model.Products;

/**
 * Main controller class for the REST Engine.
 * @author Santhoshkumar.D
 *
 */
@RestController
@RequestMapping(path = Constants.API_COMMON_PATH)
public class RestApiController {

	/**
	 * Method to fetch list list of product details with proper response code.
	 * @return list of product details
	 */
	@GetMapping(path = Constants.API_PRODUCT_DETAILS_PATH)
	public ResponseEntity<Products> getProductDetails() {
		Products products = new Products();
		
		Product dellProduct = new Product(5, "Dell", "Dell Portable Computer", 80000);
		Product hpProduct = new Product(7, "HP", "HP Portable Computer", 76000);
		List<Product> productList = new ArrayList<Product>(); 
		productList.add(dellProduct);
		productList.add(hpProduct);
		
		products.setProducts(productList);
		return new ResponseEntity<Products>(products, HttpStatus.OK);
		
	}
	
	/**
	 * Method to fetch list list of configuration details with proper response code.
	 * @return list of configuration details
	 */
	@GetMapping(path = Constants.API_CONFIG_DETAILS_PATH)
	public ResponseEntity<Configurations> getConfigDetails() {
		Configurations configurations = new Configurations();
		
		Configuration systemConfig = new Configuration(6, "System Config", "Configuration for system");
		Configuration laptopConfig = new Configuration(8, "Laptop Config", "Configuration for Laptop");
		List<Configuration> configurationList = new ArrayList<Configuration>();
		configurationList.add(systemConfig);
		configurationList.add(laptopConfig);
		
		configurations.setConfigurations(configurationList);
		return new ResponseEntity<Configurations>(configurations, HttpStatus.OK);
	}
	
}
