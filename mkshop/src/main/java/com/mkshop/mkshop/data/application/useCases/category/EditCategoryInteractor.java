package com.mkshop.mkshop.data.application.useCases.category;

import com.mkshop.mkshop.data.application.gateways.CategoryGateway;
import com.mkshop.mkshop.domain.entities.CategoryEntity;

import java.util.List;

public class EditCategoryInteractor {
    private CategoryGateway categoryGateway;

    public EditCategoryInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public CategoryEntity editCategory(String id, CategoryEntity categoryEntity) {
        return this.categoryGateway.editCategory(id, categoryEntity);
    }
}
