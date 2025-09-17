package com.product.crudapp.service;

import java.util.List;

import com.product.crudapp.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product createProduct(Product product);
	Product getSingleProduct(Long productId);
	void deleteProduct(Long productId);
	Product updateProduct(Product product);
	
}
