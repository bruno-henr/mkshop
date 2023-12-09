package com.mkshop.mkshop.data.application.useCases.product;

import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.domain.entities.ProductEntity;

import java.util.List;

public class GetAllMainProductsInteractor {
    private ProductGateway productGateway;

    public GetAllMainProductsInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<ProductEntity> getAllMain() {
        return this.productGateway.getAllMainProducts();
    }
}
