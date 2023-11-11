package com.mkshop.mkshop.controller;

import com.mkshop.mkshop.DTO.OrderDTO;
import com.mkshop.mkshop.ResponseAPI;
import com.mkshop.mkshop.model.Order;
import com.mkshop.mkshop.model.ProductOrder;
import com.mkshop.mkshop.model.ProductQtdOrderKey;
import com.mkshop.mkshop.repository.OrderRepository;
import com.mkshop.mkshop.repository.ProductOrderRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @GetMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<Order>>> getAllOrders() {
        try {
            List<Order> orders = this.orderRepository.findAll();
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

    @GetMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Optional<Order>>> getOrderById(@PathVariable String id) {
        try {
            Optional<Order> order = this.orderRepository.findById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(order, false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<Order>> addOrder(@RequestBody @Valid OrderDTO orderDTO) {
        try {
            // criar a ordem
            // criar o relacionamento
            Order order = new Order();
            order.setAddress(orderDTO.address());
            order.setMethod_payment(orderDTO.method_payment());
            order.setUser(orderDTO.user());

            Order orderSaved = this.orderRepository.save(order);

            List<ProductOrder> productOrderList = new ArrayList<>();

            orderDTO.productsOrder().stream().forEach(po -> {
                ProductOrder productOrder = new ProductOrder();

                ProductQtdOrderKey poK = new ProductQtdOrderKey();
                poK.setProductId(po.product().getId());
                poK.setOrderId(orderSaved.getId());

                productOrder.setOrder(orderSaved);
                productOrder.setProduct(po.product());
                productOrder.setQtd(po.qtd());
                productOrder.setId(poK);

                ProductOrder productOrderSaved = this.productOrderRepository.save(productOrder);
                productOrderList.add(productOrderSaved);
            });

            orderSaved.setProductOrders(productOrderList);
            this.orderRepository.save(orderSaved);

            return new ResponseEntity<>(
                    new ResponseAPI<>(orderSaved, false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Order>> putOrder(
            @PathVariable String id,
            @RequestBody @Valid OrderDTO orderDTO
    ) {
        try {
            Order order = this.orderRepository.findById(id).get();
            order.setAddress(orderDTO.address() != null ? orderDTO.address() : order.getAddress());
            order.setMethod_payment(orderDTO.method_payment() != null ? orderDTO.method_payment() : order.getMethod_payment());
            order.setUser(orderDTO.user() != null ? orderDTO.user() : order.getUser());

            Order orderSaved = this.orderRepository.save(order);

            List<ProductOrder> productOrderList = new ArrayList<>();

            orderDTO.productsOrder().stream().forEach(po -> {
                ProductOrder productOrder = new ProductOrder();

                ProductQtdOrderKey poK = new ProductQtdOrderKey();
                poK.setProductId(po.product().getId());
                poK.setOrderId(orderSaved.getId());

                productOrder.setOrder(orderSaved);
                productOrder.setProduct(po.product());
                productOrder.setQtd(po.qtd());
                productOrder.setId(poK);

                ProductOrder productOrderSaved = this.productOrderRepository.save(productOrder);
                productOrderList.add(productOrderSaved);
            });

            orderSaved.setProductOrders(productOrderList);

            this.orderRepository.save(orderSaved);

            return new ResponseEntity<>(
                    new ResponseAPI<>(orderSaved, false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> removeOrderById(@PathVariable String id) {
        try {
            this.orderRepository.deleteById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>("Pedido removido com sucesso.", false, HttpStatus.OK.value(), null),
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
