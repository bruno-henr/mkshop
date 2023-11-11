package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, String> {
}
