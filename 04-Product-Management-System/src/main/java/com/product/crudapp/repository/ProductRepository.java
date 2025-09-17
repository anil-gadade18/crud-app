package com.product.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.crudapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
