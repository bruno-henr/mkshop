package com.mkshop.mkshop.model;

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

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ImageProduct> imageProducts;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<ProductOrder> productOrders;
}
