package com.mkshop.mkshop.data.infrastructure.gateways;

import com.mkshop.mkshop.data.application.gateways.ProductOrderGateway;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.data.infrastructure.persistence.ProductOrderRepository;
import com.mkshop.mkshop.data.mappers.ProductOrderMapper;
import com.mkshop.mkshop.domain.entities.ProductOrderEntity;

import java.util.List;

public class ProductOrderGatewayRepository implements ProductOrderGateway {
    private ProductOrderRepository productOrderRepository;
    private ProductOrderMapper productOrderMapper;

    public ProductOrderGatewayRepository(
            ProductOrderRepository productOrderRepository,
            ProductOrderMapper productOrderMapper
    ) {
        this.productOrderRepository = productOrderRepository;
        this.productOrderMapper = productOrderMapper;
    }

    @Override
    public List<ProductOrderEntity> getAllProductOrders(String order_id) {
        List<ProductOrder> productOrderList = order_id != null ?
                this.productOrderRepository.findByOrderId(order_id) :
                this.productOrderRepository.findAll();

        return productOrderList
                .stream()
                .map(this.productOrderMapper::toEntity)
                .toList();
    }
}
