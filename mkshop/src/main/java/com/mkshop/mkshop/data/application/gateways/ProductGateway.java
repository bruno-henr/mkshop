package com.mkshop.mkshop.data.application.gateways;

import com.mkshop.mkshop.domain.entities.ProductEntity;

import java.util.List;

public interface ProductGateway {
    ProductEntity createProduct(ProductEntity productEntity);
    List<ProductEntity> getAllMainProducts();
    List<ProductEntity> getAllProducts();
    ProductEntity getProductById(String id);
    ProductEntity editProduct(String id, ProductEntity productEntity);
    String deleteProductById(String id);

    List<ProductEntity> getProductsByName(String name);
}
