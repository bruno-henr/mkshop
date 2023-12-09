package com.mkshop.mkshop.data.infrastructure.model;

import com.mkshop.mkshop.domain.entities.ProductOrderEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

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

    public Order(
            String method_payment,
            User user,
            Address address,
            List<ProductOrder> productOrders
    ) {
        this.method_payment = method_payment;
        this.user = user;
        if(address != null) {
            this.address = address;
        }
        if(productOrders != null) {
            this.productOrders = productOrders;
        }

    }
}
