package com.mkshop.mkshop.data.infrastructure.controllers.category;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.category.GetAllCategoriesInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.domain.entities.CategoryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllCategoryController {
    private final GetAllCategoriesInteractor getAllCategoriesInteractor;

    public GetAllCategoryController(GetAllCategoriesInteractor getAllCategoriesInteractor) {
        this.getAllCategoriesInteractor = getAllCategoriesInteractor;
    }

    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<CategoryEntity>>> getAllCategory() {
        try {
            List<CategoryEntity> categoryEntities = this.getAllCategoriesInteractor.getAllCategories();
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            categoryEntities,
                            false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
