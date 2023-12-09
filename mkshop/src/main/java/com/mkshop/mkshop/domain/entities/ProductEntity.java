package com.mkshop.mkshop.domain.entities;

import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.data.infrastructure.model.ImageProduct;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;

import java.util.List;


public record ProductEntity(
        String name,

        Number price,

        String fabricator,

        String composition,

        Integer StockQuantity,

        String img_url,

        Category category,

        List<ImageProduct> imageProducts,

        List<ProductOrder> productOrders
) {

}
