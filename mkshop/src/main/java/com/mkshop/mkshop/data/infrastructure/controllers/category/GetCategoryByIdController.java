package com.mkshop.mkshop.data.infrastructure.controllers.category;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.category.GetCategoryByIdInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Category;
import com.mkshop.mkshop.domain.entities.CategoryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetCategoryByIdController {

    private final GetCategoryByIdInteractor getCategoryByIdInteractor;

    public GetCategoryByIdController(GetCategoryByIdInteractor getCategoryByIdInteractor) {
        this.getCategoryByIdInteractor = getCategoryByIdInteractor;
    }

    @GetMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<CategoryEntity>> getCategoryById(
            @PathVariable String id
    ) {
        try {
            CategoryEntity category = this.getCategoryByIdInteractor.getCategoryById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(category, false, HttpStatus.OK.value(), null),
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
