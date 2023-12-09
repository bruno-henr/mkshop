package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.data.infrastructure.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, String> {
    //@Query("SELECT p FROM product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByMainIsTrue();
}
