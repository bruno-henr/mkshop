package com.mkshop.mkshop.data.application.useCases.product;

import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.domain.entities.ProductEntity;

import java.util.List;

public class GetAllProductsInteractor {
    private ProductGateway productGateway;

    public GetAllProductsInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<ProductEntity> getAll() {
        return this.productGateway.getAllProducts();
    }
}
