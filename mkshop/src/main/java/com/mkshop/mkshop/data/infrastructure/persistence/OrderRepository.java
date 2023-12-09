package com.mkshop.mkshop.data.infrastructure.persistence;

import com.mkshop.mkshop.data.infrastructure.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query(value = "select * from order_user o where o.user_id = ?1", nativeQuery = true)
    List<Order> findOrderByUserId(String user_id);
}
