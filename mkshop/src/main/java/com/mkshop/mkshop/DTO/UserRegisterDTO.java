package com.mkshop.mkshop.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mkshop.mkshop.enums.UserRole;
import com.mkshop.mkshop.model.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public record UserRegisterDTO(
        String full_name,
        String username,
        String password,
        String phone_number,
        String cpf,
        UserRole role
        //Address address
) {
}
