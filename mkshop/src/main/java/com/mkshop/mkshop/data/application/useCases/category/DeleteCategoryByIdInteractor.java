package com.mkshop.mkshop.data.application.useCases.category;

import com.mkshop.mkshop.data.application.gateways.CategoryGateway;
import com.mkshop.mkshop.domain.entities.CategoryEntity;

public class DeleteCategoryByIdInteractor {
    private CategoryGateway categoryGateway;

    public DeleteCategoryByIdInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public String deleteCategoryById(String id) {
        return this.categoryGateway.deleteCategoryById(id);
    }
}
