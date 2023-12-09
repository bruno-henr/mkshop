package com.mkshop.mkshop.domain.entities;

import jakarta.annotation.Nullable;

public record ProductOrderEntity(
        ProductEntity product,
        OrderEntity order,
        Integer qtd,
        @Nullable String id
) { }
