package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.data.infrastructure.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageProductRepository extends JpaRepository<ImageProduct, String> {
}
