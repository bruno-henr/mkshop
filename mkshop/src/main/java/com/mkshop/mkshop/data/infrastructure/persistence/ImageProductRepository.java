package com.mkshop.mkshop.data.infrastructure.persistence;

import com.mkshop.mkshop.data.infrastructure.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageProductRepository extends JpaRepository<ImageProduct, String> {
}
