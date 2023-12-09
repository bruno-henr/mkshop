package com.mkshop.mkshop.data.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkshop.mkshop.domain.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> product;

    public Category(String id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }
}
