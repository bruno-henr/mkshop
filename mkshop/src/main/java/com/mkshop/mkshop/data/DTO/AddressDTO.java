package com.mkshop.mkshop.data.DTO;

import jakarta.persistence.Column;

public record AddressDTO(
        String neighborhood,
        String street,
        String number
) {
}
