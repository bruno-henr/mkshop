package com.mkshop.mkshop.domain.entities;

import com.mkshop.mkshop.data.infrastructure.model.Order;
import com.mkshop.mkshop.data.infrastructure.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record ProductOrderEntity(
        Product product,
        Order order,
        Integer qtd
) { }
