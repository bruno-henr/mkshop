package com.mkshop.mkshop.data.application.useCases.product;

import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.domain.entities.ProductEntity;

import java.util.List;

public class GetProductByIdInteractor {
    private ProductGateway productGateway;

    public GetProductByIdInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public ProductEntity getProductById(String id) {
        return this.productGateway.getProductById(id);
    }
}
