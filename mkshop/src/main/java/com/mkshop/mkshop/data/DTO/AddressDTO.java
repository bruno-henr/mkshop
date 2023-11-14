package com.mkshop.mkshop.domain.DTO;

import jakarta.persistence.Column;

public record AddressDTO(
        String neighborhood,
        String street,
        String number
) {
}
