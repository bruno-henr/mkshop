package com.mkshop.mkshop.data.application.useCases.order;

import com.mkshop.mkshop.data.application.gateways.OrderGateway;
import com.mkshop.mkshop.domain.entities.OrderEntity;

public class CreateOrderInteractor {
    private OrderGateway orderGateway;

    public CreateOrderInteractor(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    public OrderEntity addOrder(OrderEntity orderEntity) {
        return this.orderGateway.createOrder(orderEntity);
    }
}
