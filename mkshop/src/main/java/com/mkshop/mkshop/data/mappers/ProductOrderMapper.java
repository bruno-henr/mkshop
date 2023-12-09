package com.mkshop.mkshop.data.mappers;

import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.domain.entities.ProductOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderMapper {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;


    public ProductOrderEntity toEntity(ProductOrder productOrder) {
        return new ProductOrderEntity(
                this.productMapper.toEntity(productOrder.getProduct()),
                this.orderMapper.toEntity(productOrder.getOrder()),
                productOrder.getQtd(),
                productOrder.getId()
        );
    }

    public ProductOrder toModel(ProductOrderEntity p) {
        return new ProductOrder(
                this.productMapper.toModel(p.product()),
                this.orderMapper.toModel(p.order()),
                p.qtd()
        );
    }
}
