package com.mkshop.mkshop.domain.entities;

import jakarta.annotation.Nullable;

public record Address(
        String neighborhood,
        String street,
        String number,
        @Nullable String id

) {

}
