package com.mkshop.mkshop.data.mappers;

import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.data.infrastructure.model.Product;
import com.mkshop.mkshop.data.infrastructure.persistence.CategoryRepository;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getName(),
                product.getPrice(),
                product.getFabricator(),
                product.getComposition(),
                product.getStockQuantity(),
                product.getImg_url(),
                product.isMain(),
                product.getCategory().getId(),
                product.getImageProducts(),
                product.getProductOrders(),
                product.getId()
        );
    }

    public Product toModel(ProductEntity product) {
        Category category = this.categoryRepository.findById(product.categoryId()).get();

        return new Product(
                product.name(),
                product.price(),
                product.fabricator(),
                product.composition(),
                product.StockQuantity(),
                product.img_url(),
                product.main(),
                category,
                product.imageProducts(),
                product.productOrders(),
                product.id()
        );
    }
}
