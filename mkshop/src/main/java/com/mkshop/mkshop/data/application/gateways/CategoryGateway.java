package com.mkshop.mkshop.data.application.gateways;

import com.mkshop.mkshop.domain.entities.CategoryEntity;

import java.util.List;

public interface CategoryGateway {
    CategoryEntity createCategory(CategoryEntity category);
    String deleteCategoryById(String id);
    CategoryEntity editCategory(String id, CategoryEntity categoryEntity);
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategoryById(String id);
}
