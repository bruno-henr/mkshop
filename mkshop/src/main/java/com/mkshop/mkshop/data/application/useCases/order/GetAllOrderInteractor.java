package com.mkshop.mkshop.data.infrastructure.controllers.order;

import com.mkshop.mkshop.data.application.gateways.OrderGateway;
import com.mkshop.mkshop.domain.entities.OrderEntity;

import java.util.List;

public class GetAllOrderInteractor {
    private OrderGateway orderGateway;

    public GetAllOrderInteractor(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    public List<OrderEntity> getAllOrders() {
        return this.orderGateway.getAllOrders();
    }
}
