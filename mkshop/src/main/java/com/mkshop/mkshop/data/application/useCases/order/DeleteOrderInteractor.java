package com.mkshop.mkshop.data.infrastructure.controllers.order;

import com.mkshop.mkshop.data.application.gateways.OrderGateway;
import com.mkshop.mkshop.domain.entities.OrderEntity;

import java.util.List;

public class DeleteOrderInteractor {
    private OrderGateway orderGateway;

    public DeleteOrderInteractor(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    public String deleteOrderById(String id) {
        return this.orderGateway.deleteOrderById(id);
    }
}
