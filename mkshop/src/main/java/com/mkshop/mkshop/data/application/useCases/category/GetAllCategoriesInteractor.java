package com.mkshop.mkshop.data.application.useCases.category;

import com.mkshop.mkshop.data.application.gateways.CategoryGateway;
import com.mkshop.mkshop.domain.entities.CategoryEntity;

import java.util.List;

public class GetAllCategoriesInteractor {
    private CategoryGateway categoryGateway;

    public GetAllCategoriesInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public List<CategoryEntity> getAllCategories() {
        return this.categoryGateway.getAllCategories();
    }
}
