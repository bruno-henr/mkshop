package com.mkshop.mkshop.data.infrastructure.controllers.order;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.order.GetAllOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.order.GetOrderInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Order;
import com.mkshop.mkshop.domain.entities.OrderEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllOrderController {
    private final GetAllOrderInteractor getAllOrderInteractor;
    private final GetOrderInteractor getOrderByIdInteractor;

    public GetAllOrderController(
            GetAllOrderInteractor getAllOrderInteractor,
            GetOrderInteractor getOrderByIdInteractor
    ) {
        this.getAllOrderInteractor = getAllOrderInteractor;
        this.getOrderByIdInteractor = getOrderByIdInteractor;
    }

    @GetMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<OrderEntity>>> getAllOrders(
            @RequestParam(value = "user_id", required = false) String user_id
    ) {
        try {
            List<OrderEntity> orders = user_id != null ?
                    this.getOrderByIdInteractor.getOrderById(user_id) :
                    this.getAllOrderInteractor.getAllOrders();

            return new ResponseEntity<>(
                    new ResponseAPI<>(orders, false, HttpStatus.OK.value(), null),
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
