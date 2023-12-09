package com.mkshop.mkshop.data.DTO;

import com.mkshop.mkshop.data.infrastructure.model.Address;
import com.mkshop.mkshop.data.infrastructure.model.User;

import java.util.List;

public record OrderDTO(
        String method_payment,
        User user,
        Address address,
        List<ProductOrderDTO> productsOrder
) {
}
