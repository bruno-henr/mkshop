package com.mkshop.mkshop.data.application.useCases.category;

import com.mkshop.mkshop.data.application.gateways.CategoryGateway;
import com.mkshop.mkshop.domain.entities.CategoryEntity;

public class CreateCategoryInteractor {
    private CategoryGateway categoryGateway;

    public CreateCategoryInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return this.categoryGateway.createCategory(categoryEntity);
    }
}
