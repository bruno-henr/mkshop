package com.mkshop.mkshop.data.infrastructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductQtdOrderKey implements Serializable {
    @Column(name = "product_id")
    String productId;

    @Column(name = "order_id")
    String orderId;
}
