package com.mkshop.mkshop.data.application.useCases.product_order;

import com.mkshop.mkshop.data.application.gateways.ProductOrderGateway;
import com.mkshop.mkshop.data.application.useCases.product.GetAllProductsInteractor;
import com.mkshop.mkshop.domain.entities.ProductOrderEntity;

import java.util.List;

public class GetAllProductOrderInteractor {
    private ProductOrderGateway productOrderGateway;

    public GetAllProductOrderInteractor(ProductOrderGateway productOrderGateway) {
        this.productOrderGateway = productOrderGateway;
    }

    public List<ProductOrderEntity> getAllProductOrders(String order_id) {
        return this.productOrderGateway.getAllProductOrders(order_id);
    }
}
