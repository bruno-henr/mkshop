package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
