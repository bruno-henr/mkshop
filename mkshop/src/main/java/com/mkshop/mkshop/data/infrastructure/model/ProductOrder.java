package com.mkshop.mkshop.data.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_order")
@Entity
public class ProductOrder {

//    @EmbeddedId
//    ProductQtdOrderKey id;
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;

//    @ManyToOne
//    @MapsId("productId")
//    @JoinColumn(name = "product_id")
//    @JsonIgnore
//    private Product product;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToOne
//    @MapsId("orderId")
//    @JoinColumn(name = "order_id")
//    @JsonIgnore
//    private Order order;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Column
    private Integer qtd;

    public ProductOrder(Product product, Order order, Integer qtd) {
        this.product = product;
        this.order = order;
        this.qtd = qtd;
    }
}
