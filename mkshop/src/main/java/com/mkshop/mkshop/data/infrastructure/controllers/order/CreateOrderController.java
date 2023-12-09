package com.mkshop.mkshop.data.infrastructure.controllers.order;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.DTO.OrderDTO;
import com.mkshop.mkshop.data.application.useCases.order.CreateOrderInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Order;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.domain.entities.OrderEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CreateOrderController {
    private final CreateOrderInteractor createOrderInteractor;

    public CreateOrderController(CreateOrderInteractor createOrderInteractor) {
        this.createOrderInteractor = createOrderInteractor;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<OrderEntity>> addOrder(@RequestBody @Valid OrderEntity orderEntity) {
        try {
            OrderEntity orderSaved = this.createOrderInteractor.addOrder(orderEntity);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            orderSaved,
                            false,
                            HttpStatus.CREATED.value(),
                            null
                    ),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
