package com.mkshop.mkshop.data.infrastructure.controllers.product;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product.EditProductInteractor;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EditProductController {
    private final EditProductInteractor editProductInteractor;

    public EditProductController(EditProductInteractor editProductInteractor) {
        this.editProductInteractor = editProductInteractor;
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<ProductEntity>> editProduct(
            @RequestBody @Valid ProductEntity product, @PathVariable String id
    ) {
        try {
            ProductEntity productEdited = this.editProductInteractor
                    .editProduct(id, product);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            productEdited,
                            false,
                            HttpStatus.OK.value(),
                            null
                    ),
                    HttpStatus.OK
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null,
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
