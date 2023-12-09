package com.mkshop.mkshop.domain.entities;

import com.mkshop.mkshop.data.infrastructure.model.Address;
import com.mkshop.mkshop.data.infrastructure.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record OrderEntity(
         String method_payment,
         User user,
         Address address,
        List<ProductOrder> productOrders
) { }
