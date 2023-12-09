package com.mkshop.mkshop.data.infrastructure.controllers.category;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.category.DeleteCategoryByIdInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCategoryController {
    private final DeleteCategoryByIdInteractor deleteCategoryByIdInteractor;

    public DeleteCategoryController(DeleteCategoryByIdInteractor deleteCategoryByIdInteractor) {
        this.deleteCategoryByIdInteractor = deleteCategoryByIdInteractor;
    }

    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> deleteById(@PathVariable String id) {
        try {
            String result = this.deleteCategoryByIdInteractor.deleteCategoryById(id);
            return new ResponseEntity<>(
                    new ResponseAPI<String>(
                            result,
                            false,
                            HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            "Erro ao excluir categoria",
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
