package com.mkshop.mkshop.domain.entities;

import com.mkshop.mkshop.data.enums.UserRole;
import com.mkshop.mkshop.data.infrastructure.model.Address;
import com.mkshop.mkshop.data.infrastructure.model.Order;
import jakarta.annotation.Nullable;

import java.util.List;

public record UserEntity(
        String full_name,String username,
        String password, String phone_number,
        String cpf, Address address,
        List<Order> order, UserRole role,
        @Nullable String id
) { }
