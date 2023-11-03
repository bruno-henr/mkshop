package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
