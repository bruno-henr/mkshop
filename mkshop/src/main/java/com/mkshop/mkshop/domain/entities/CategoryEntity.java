package com.mkshop.mkshop.domain.entities;

import jakarta.annotation.Nullable;
import java.util.List;

public record Category(
        String name,
        List<Product> product,
        @Nullable String id
) { }
