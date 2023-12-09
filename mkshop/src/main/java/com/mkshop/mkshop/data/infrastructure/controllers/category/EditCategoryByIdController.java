package com.mkshop.mkshop.data.infrastructure.controllers.category;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.category.EditCategoryInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.domain.entities.CategoryEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EditCategoryByIdController {
    private final EditCategoryInteractor editCategoryInteractor;

    public EditCategoryByIdController(EditCategoryInteractor editCategoryInteractor) {
        this.editCategoryInteractor = editCategoryInteractor;
    }

    @PutMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<CategoryEntity>> editCategory(@RequestBody @Valid CategoryEntity category, @PathVariable String id) {
        try {
            CategoryEntity categoryEdited = this.editCategoryInteractor.editCategory(id, category);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            categoryEdited,
                            false,
                            HttpStatus.OK.value(),
                            null
                    ),
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
