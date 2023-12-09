package com.mkshop.mkshop.data.application.useCases.product;

import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.domain.entities.ProductEntity;

public class CreateProductInteractor {

    private ProductGateway productGateway;

    public CreateProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public ProductEntity createProduct(ProductEntity productEntity) {
        return this.productGateway.createProduct(productEntity);
    }
}
