package com.mkshop.mkshop.DTO;

import com.mkshop.mkshop.model.Product;

public record ProductOrderDTO(
        Product product,
        Integer qtd
) {
}
