package com.mkshop.mkshop.data.infrastructure.controllers.product;


import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product.DeleteProductInteractor;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProductController {
    private final DeleteProductInteractor deleteProductInteractor;

    public DeleteProductController(DeleteProductInteractor deleteProductInteractor) {
        this.deleteProductInteractor = deleteProductInteractor;
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> deleteProductById(@PathVariable String id) {
        try {
            String result = this.deleteProductInteractor.deleteProductById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            result,
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
