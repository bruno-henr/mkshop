package com.mkshop.mkshop.data.application.useCases.category;

import com.mkshop.mkshop.data.application.gateways.CategoryGateway;
import com.mkshop.mkshop.domain.entities.CategoryEntity;

public class GetCategoryByIdInteractor {
    private CategoryGateway categoryGateway;

    public GetCategoryByIdInteractor(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public CategoryEntity getCategoryById(String id) {
        return this.categoryGateway.getCategoryById(id);
    }
}
