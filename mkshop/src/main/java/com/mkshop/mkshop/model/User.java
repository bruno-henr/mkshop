package com.mkshop.mkshop.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    @CreationTimestamp
    private Date created_at;

    @Column
    @UpdateTimestamp
    private Date updated_at;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String username;

    @Column
    private String phone_number;

    @Column(nullable = false)
    private String cpf;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "user_order")
    private List<Order> order;
}
