package com.product.crudapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.crudapp.model.Product;
import com.product.crudapp.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	
	@GetMapping("/list")
	public String listOfAllProducts(Model model) {
		List<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		return "product-list";
	}
	
	@GetMapping("/product-form")
	public String showProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "product-form";
		}
		this.productService.createProduct(product);
		return "redirect:/list";
	}
	
	@GetMapping("/delete-product/{productId}")
	public String deleteProduct(@PathVariable("productId") Long productId) {
		this.productService.deleteProduct(productId);
		return "redirect:/list";
	}
	
	@GetMapping("/update-form/{productId}")
	public String updateProductForm(@PathVariable("productId") Long productId, Model model) {
		Product product = this.productService.getSingleProduct(productId);
		model.addAttribute("product", product);
		return "update-form";
	}
	
	@PostMapping("/update-product")
	public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "update-form";
		}
		this.productService.updateProduct(product);
		return "redirect:/list";
	}
}
