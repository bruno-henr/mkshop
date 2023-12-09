package com.mkshop.mkshop.data.infrastructure.controllers.product;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product.GetProductByIdInteractor;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class GetProductByIdController {
    private final GetProductByIdInteractor getProductByIdInteractor;

    public GetProductByIdController(GetProductByIdInteractor getProductByIdInteractor) {
        this.getProductByIdInteractor = getProductByIdInteractor;
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<ProductEntity>> getProductById(
            @PathVariable String id
    ) {
        try {
            ProductEntity productEntityList = this.getProductByIdInteractor.getProductById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            productEntityList,
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
