package com.mkshop.mkshop.data.infrastructure.controllers.category;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.category.CreateCategoryInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.domain.entities.CategoryEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCategoryController {
    private final CreateCategoryInteractor createCategoryInteractor;

    public CreateCategoryController(CreateCategoryInteractor createCategoryInteractor) {
        this.createCategoryInteractor = createCategoryInteractor;
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<CategoryEntity>> createCategory(@RequestBody @Valid CategoryEntity category) {
        try {
            CategoryEntity categorySaved = this.createCategoryInteractor.createCategory(category);
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            categorySaved,
                            false,
                            HttpStatus.CREATED.value(),
                            null
                    ),
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
