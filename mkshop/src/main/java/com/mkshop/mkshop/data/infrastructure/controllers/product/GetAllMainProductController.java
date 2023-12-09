package com.mkshop.mkshop.data.infrastructure.controllers.product;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product.GetAllMainProductsInteractor;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllMainProductController {
    private final GetAllMainProductsInteractor getAllMainProductsInteractor;

    public GetAllMainProductController(GetAllMainProductsInteractor getAllMainProductsInteractor) {
        this.getAllMainProductsInteractor = getAllMainProductsInteractor;
    }

    @GetMapping("/product/main")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<ProductEntity>>> getAllProduct() {
        try {
            List<ProductEntity> productEntities = this.getAllMainProductsInteractor
                    .getAllMain();

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            productEntities,
                            false,
                            HttpStatus.OK.value(),
                            null
                    ), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null,
                            true,
                            HttpStatus.OK.value(),
                            e.toString()
                    ), HttpStatus.OK
            );
        }
    }
}
