package com.mkshop.mkshop.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkshop.mkshop.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record ImageProductDTO(
        String img_url, Product product
) {
}
