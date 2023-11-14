package com.mkshop.mkshop.domain.DTO;

import com.mkshop.mkshop.model.Address;
import com.mkshop.mkshop.model.User;

import java.util.List;

public record OrderDTO(
        String method_payment,
        User user,
        Address address,
        List<ProductOrderDTO> productsOrder
) {
}
