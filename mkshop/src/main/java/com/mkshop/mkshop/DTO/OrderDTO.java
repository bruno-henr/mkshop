package com.mkshop.mkshop.DTO;

import com.mkshop.mkshop.model.Address;
import com.mkshop.mkshop.model.ProductOrder;
import com.mkshop.mkshop.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public record OrderDTO(
        String method_payment,
        User user,
        Address address,
        List<ProductOrderDTO> productsOrder
) {
}
