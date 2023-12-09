package com.mkshop.mkshop.data.infrastructure.controllers.product;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product.GetAllProductsInteractor;
import com.mkshop.mkshop.data.application.useCases.product.GetProductsByNameInteractor;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllProductController {
    private final GetAllProductsInteractor getAllProductsInteractor;
    private final GetProductsByNameInteractor getProductsByNameInteractor;

    public GetAllProductController(
            GetAllProductsInteractor getAllProductsInteractor,
            GetProductsByNameInteractor getProductsByNameInteractor
    ) {
        this.getAllProductsInteractor = getAllProductsInteractor;
        this.getProductsByNameInteractor = getProductsByNameInteractor;
    }

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<ProductEntity>>> getAllProduct(
            @RequestParam(value = "name", required = false) String name
    ) {
        try {
            if (name == null) {
                return new ResponseEntity<>(
                        new ResponseAPI<>(
                                this.getAllProductsInteractor.getAll(),
                                false,
                                HttpStatus.OK.value(),
                                null
                        ), HttpStatus.OK
                );
            }

            List<ProductEntity> productList = this.getProductsByNameInteractor.getAllByName(name);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            productList,
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
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ), HttpStatus.BAD_REQUEST
            );
        }
    }
}
