package com.mkshop.mkshop.data.mappers;

import com.mkshop.mkshop.data.infrastructure.model.Order;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.domain.entities.OrderEntity;
import com.mkshop.mkshop.domain.entities.ProductOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {
    @Autowired
    ProductOrderMapper productOrderMapper;

    @Autowired
    ProductMapper productMapper;

    public OrderEntity toEntity(Order order) {
        List<ProductOrderEntity> productOrderEntities =

                order.getProductOrders()
                .stream()
                .map(p -> {
                    ProductOrderEntity poe = new ProductOrderEntity(
                            this.productMapper.toEntity(p.getProduct()),
                            null,
                            p.getQtd(),
                            null
                    );
                    return poe;
                    //this.productOrderMapper.toEntity(p)
                })
                .toList();

        return new OrderEntity(
                order.getMethod_payment(),
                order.getUser(),
                order.getAddress(),
                productOrderEntities,
                order.getId()
        );
    }

    public Order toModel(OrderEntity o) {
        List<ProductOrder> productOrderList = o.productOrders()
                .stream()
                .map(p -> this.productOrderMapper.toModel(p)).toList();


        return new Order(
                o.method_payment(),
                o.user(),
                o.address(),
                productOrderList
        );
    }
}
