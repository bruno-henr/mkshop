package com.mkshop.mkshop.data.DTO;

import com.mkshop.mkshop.data.infrastructure.model.Product;

public record ImageProductDTO(
        String img_url, Product product
) {
}
