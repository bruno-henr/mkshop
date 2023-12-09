package com.mkshop.mkshop.data.application.gateways;

import com.mkshop.mkshop.domain.entities.OrderEntity;

import java.util.List;

public interface OrderGateway {
    OrderEntity createOrder(OrderEntity orderEntity);
    String deleteOrderById(String id);
    List<OrderEntity> getAllOrders();
    List<OrderEntity> getOrderByUserId(String id);
}
