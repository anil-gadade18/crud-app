package com.product.crudapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.crudapp.model.Product;
import com.product.crudapp.repository.ProductRepository;
import com.product.crudapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) {	
		Double total = product.getPrice()*product.getQuantity();
		product.setTotal(total);
		return this.productRepository.save(product);
	}

	@Override
	public Product getSingleProduct(Long productId) {
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = productRepository.findById(productId).get();
		this.productRepository.delete(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Double total = product.getPrice() * product.getQuantity();
		product.setTotal(total);
		return this.productRepository.save(product);
	}

}
