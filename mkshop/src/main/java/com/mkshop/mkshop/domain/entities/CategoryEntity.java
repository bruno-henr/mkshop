package com.mkshop.mkshop.domain.entities;

import jakarta.annotation.Nullable;
import java.util.List;

public record CategoryEntity(
        String name,
        List<ProductEntity> product,
        @Nullable String id
) { }
