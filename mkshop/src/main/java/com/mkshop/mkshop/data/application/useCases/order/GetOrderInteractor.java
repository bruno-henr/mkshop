package com.mkshop.mkshop.data.application.useCases.order;

import com.mkshop.mkshop.data.application.gateways.OrderGateway;
import com.mkshop.mkshop.domain.entities.OrderEntity;

import java.util.List;

public class GetOrderInteractor {
    private OrderGateway orderGateway;

    public GetOrderInteractor(OrderGateway orderGateway){
        this.orderGateway = orderGateway;
    }

    public List<OrderEntity> getOrderById(String id) {
        return this.orderGateway.getOrderByUserId(id);
    }
}
