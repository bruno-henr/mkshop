package com.mkshop.mkshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order_user")
@Entity
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    @CreationTimestamp
    private Date created_at;

    @Column
    @UpdateTimestamp
    private Date updated_at;

    @Column
    private String method_payment;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_order_id")
    private Address address;

    @OneToMany(mappedBy = "order")
    List<ProductOrder> productOrders;
}
