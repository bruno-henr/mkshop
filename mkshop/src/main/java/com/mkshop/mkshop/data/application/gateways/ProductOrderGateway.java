package com.mkshop.mkshop.data.application.gateways;

import com.mkshop.mkshop.domain.entities.ProductOrderEntity;

import java.util.List;

public interface ProductOrderGateway {
    List<ProductOrderEntity> getAllProductOrders(String order_id);
}
