package com.mkshop.mkshop.domain.entities;

import com.mkshop.mkshop.data.enums.UserRole;
import com.mkshop.mkshop.data.model.Address;
import com.mkshop.mkshop.data.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String full_name;

    private String username;

    private String password;

    private String phone_number;

    private String cpf;

    private Address address;

    private List<Order> order;

    private UserRole role;
}
