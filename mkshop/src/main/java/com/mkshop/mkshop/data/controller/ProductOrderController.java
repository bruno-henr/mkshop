package com.mkshop.mkshop.data.controller;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.data.infrastructure.persistence.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class ProductOrderController {
//    @Autowired
//    private ProductOrderRepository productOrderRepository;

//    @GetMapping("/product/order")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<List<ProductOrder>>> getAllProductOrder(
//            @RequestParam(value = "order_id", required = false) String order_id
//    ) {
//        try {
//
//            List<ProductOrder> productOrderList = order_id != null ?
//                    this.productOrderRepository.findByOrderId(order_id) :
//                    this.productOrderRepository.findAll();
//
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            productOrderList,
//                            false,
//                            HttpStatus.OK.value(),
//                            null
//                    ), HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            null,
//                            true,
//                            HttpStatus.OK.value(),
//                            e.toString()
//                    ), HttpStatus.OK
//            );
//        }
//    }
}
