package com.mkshop.mkshop.data.infrastructure.persistence;

import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, String> {
    //@Query(value = "select * from product_order p where p.order_id = ?1", nativeQuery = true)
    //List<ProductOrder> findProductOrderByOrderId(String order_id);
    List<ProductOrder> findByOrderId(String orderId);
}
