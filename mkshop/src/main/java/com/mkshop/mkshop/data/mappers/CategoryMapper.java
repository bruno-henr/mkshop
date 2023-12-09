package com.mkshop.mkshop.data.mappers;

import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.data.infrastructure.model.Product;
import com.mkshop.mkshop.domain.entities.CategoryEntity;

import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {
    @Autowired
    ProductMapper productMapper;

    public CategoryEntity toEntity(Category category) {
        List<ProductEntity> products = category.getProduct().stream().map(p ->
                this.productMapper.toEntity(p)).toList();
        return new CategoryEntity(
                category.getName(),
                products,
                category.getId()
        );
    }

    public Category toModel(CategoryEntity c) {
        List<Product> products = c.product().stream().map(p -> this.productMapper.toModel(p)).toList();

        return new Category(
                c.id(),
                c.name(),
                products
        );
    }
}
