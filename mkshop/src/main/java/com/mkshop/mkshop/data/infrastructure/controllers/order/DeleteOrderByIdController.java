package com.mkshop.mkshop.data.infrastructure.controllers.order;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.order.CreateOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.order.DeleteOrderInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteOrderByIdController {
    private final DeleteOrderInteractor deleteOrderInteractor;

    public DeleteOrderByIdController(DeleteOrderInteractor deleteOrderInteractor) {
        this.deleteOrderInteractor = deleteOrderInteractor;
    }

    @DeleteMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> removeOrderById(@PathVariable String id) {
        try {
            String result = this.deleteOrderInteractor.deleteOrderById(id);

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
