package com.mkshop.mkshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@Table
@Entity(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
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
    private String neighborhood;

    @Column
    private String street;

    @Column
    private String number;

}
