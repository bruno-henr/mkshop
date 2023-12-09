package com.mkshop.mkshop.data.infrastructure.gateways;

import com.mkshop.mkshop.data.application.gateways.OrderGateway;
import com.mkshop.mkshop.data.infrastructure.model.Order;
import com.mkshop.mkshop.data.infrastructure.model.ProductOrder;
import com.mkshop.mkshop.data.infrastructure.persistence.OrderRepository;
import com.mkshop.mkshop.data.infrastructure.persistence.ProductOrderRepository;
import com.mkshop.mkshop.data.infrastructure.persistence.ProductRepository;
import com.mkshop.mkshop.data.mappers.OrderMapper;
import com.mkshop.mkshop.data.mappers.ProductMapper;
import com.mkshop.mkshop.domain.entities.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderGatewayRepository implements OrderGateway {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final ProductOrderRepository productOrderRepository;

    public OrderGatewayRepository(
            OrderRepository orderRepository,
            OrderMapper orderMapper,
            ProductMapper productMapper,
            ProductOrderRepository productOrderRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        Order order = new Order();

        if(orderEntity.address() != null) {
            order.setAddress(orderEntity.address());
        }

        order.setMethod_payment(orderEntity.method_payment());
        order.setUser(orderEntity.user());

        Order orderSaved = this.orderRepository.save(order);
        System.out.println("ORdem salva "+orderSaved);
        List<ProductOrder> productOrderList = new ArrayList<>();

        orderEntity.productOrders().stream().forEach(po -> {
            ProductOrder productOrder = new ProductOrder();

            productOrder.setOrder(orderSaved);
            System.out.println("Produto antes "+po.product());
            productOrder.setProduct(this.productMapper.toModel(po.product()));
            System.out.println("PRODUTO DEPS "+productOrder.getProduct());
            productOrder.setQtd(po.qtd());
            System.out.println("PRODUTO ORDEM = "+productOrder);
            ProductOrder productOrderSaved = this.productOrderRepository.save(productOrder);
            productOrderList.add(productOrderSaved);
        });

        orderSaved.setProductOrders(productOrderList);
        this.orderRepository.save(orderSaved);
        System.out.println("ORDEM ANtes"+order);
        System.out.println("ORDEM "+order.toString());
        return this.orderMapper.toEntity(orderSaved);
    }

    @Override
    public String deleteOrderById(String id) {
        this.orderRepository.deleteById(id);
        return "Ordem removido com sucesso.";
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return this.orderRepository
                .findAll()
                .stream()
                .map(this.orderMapper::toEntity)
                .toList();
    }

    @Override
    public List<OrderEntity> getOrderByUserId(String id) {
        return this.orderRepository
                .findOrderByUserId(id).stream().map(this.orderMapper::toEntity).toList();
    }


}
