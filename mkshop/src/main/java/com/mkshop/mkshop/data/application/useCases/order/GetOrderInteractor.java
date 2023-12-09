package com.mkshop.mkshop.data.infrastructure.controllers.order;

import com.mkshop.mkshop.data.application.gateways.OrderGateway;
import com.mkshop.mkshop.domain.entities.OrderEntity;

import java.util.List;

public class GetOrderInteractor {
    private OrderGateway orderGateway;

    public GetOrderInteractor(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    public OrderEntity getAllOrders(String id) {
        return this.orderGateway.getOrderById(id);
    }
}
