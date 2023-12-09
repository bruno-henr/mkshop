package com.mkshop.mkshop.domain.entities;

import com.mkshop.mkshop.data.infrastructure.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record ImageProductEntity(
        String img_url,
        Product product
) {

}
