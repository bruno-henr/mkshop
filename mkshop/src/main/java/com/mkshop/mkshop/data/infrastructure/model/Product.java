package com.mkshop.mkshop.data.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
@Entity
public class Product  {

    @Id
    @GeneratedValue(strategy = UUID)
    private String id;

    @Column
    @CreationTimestamp
    private Date created_at;

    @Column
    @UpdateTimestamp
    private Date updated_at;

    @Column(
            unique = true,
            nullable = false
    )
    private String name;

    @Column
    private Number price;

    @Column(
            nullable = true
    )
    private String fabricator;

    @Column(
            nullable = true
    )
    private String composition;

    @Column
    private Integer StockQuantity;

    @Column(
            nullable = true
    )
    private String img_url;

    @Column
    private boolean main;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ImageProduct> imageProducts;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<ProductOrder> productOrders;

    public Product(
            String name, Number price, String fabricator,
            String composition, Integer stockQuantity,
            String img_url, boolean main, Category category,
            List<ImageProduct> imageProducts,
            List<ProductOrder> productOrders, String id
    ) {
        this.name = name;
        this.price = price;
        this.fabricator = fabricator;
        this.composition = composition;
        StockQuantity = stockQuantity;
        this.img_url = img_url;
        this.main = main;
        this.category = category;
        this.imageProducts = imageProducts;
        this.productOrders = productOrders;
        if(id != null) {
            this.id = id;
        }
    }
}
