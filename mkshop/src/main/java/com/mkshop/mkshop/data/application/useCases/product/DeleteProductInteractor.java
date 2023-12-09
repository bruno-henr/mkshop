package com.mkshop.mkshop.data.application.useCases.product;

import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.domain.entities.ProductEntity;

public class DeleteProductInteractor {
    private ProductGateway productGateway;

    public DeleteProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public String deleteProductById(String id) {
        return this.productGateway.deleteProductById(id);
    }
}
