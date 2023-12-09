package com.mkshop.mkshop.data.DTO;

import com.mkshop.mkshop.data.infrastructure.model.Product;

public record ProductOrderDTO(
        Product product,
        Integer qtd
) {
}
