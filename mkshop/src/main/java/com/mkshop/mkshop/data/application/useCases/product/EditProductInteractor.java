package com.mkshop.mkshop.data.application.useCases.product;

import com.mkshop.mkshop.data.application.gateways.ProductGateway;
import com.mkshop.mkshop.domain.entities.ProductEntity;

public class EditProductInteractor {
    private ProductGateway productGateway;

    public EditProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public ProductEntity editProduct(String id, ProductEntity productEntity) {
        return this.productGateway.editProduct(id, productEntity);
    }
}
