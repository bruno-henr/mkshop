package com.mkshop.mkshop.data.infrastructure.controllers.product_order;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.product_order.GetAllProductOrderInteractor;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.domain.entities.ProductOrderEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GetAllProductOrdersController {
    private GetAllProductOrderInteractor getAllProductOrderInteractor;

    public GetAllProductOrdersController(GetAllProductOrderInteractor getAllProductOrderInteractor) {
        this.getAllProductOrderInteractor = getAllProductOrderInteractor;
    }

    @GetMapping("/product/order")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<ProductOrderEntity>>> getAllProductOrder(
            @RequestParam(value = "order_id", required = false) String order_id
    ) {
        try {

            List<ProductOrderEntity> productOrderList = this.getAllProductOrderInteractor
                    .getAllProductOrders(order_id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            productOrderList,
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
