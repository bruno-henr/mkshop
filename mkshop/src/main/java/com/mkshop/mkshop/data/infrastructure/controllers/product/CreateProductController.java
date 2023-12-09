package com.mkshop.mkshop.data.infrastructure.controllers.product;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product.CreateProductInteractor;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProductController {
    private final CreateProductInteractor createProductInteractor;

    public CreateProductController(CreateProductInteractor createProductInteractor) {
        this.createProductInteractor = createProductInteractor;
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<ProductEntity>> addProduct(@RequestBody @Valid ProductEntity product) {
        try {
            ProductEntity productSaved = this.createProductInteractor.createProduct(product);

            return new ResponseEntity<>(
                    new ResponseAPI<>(product, false, HttpStatus.CREATED.value(), null),
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
