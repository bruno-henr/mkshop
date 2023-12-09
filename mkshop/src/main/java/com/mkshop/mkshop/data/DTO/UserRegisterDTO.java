package com.mkshop.mkshop.data.DTO;

import com.mkshop.mkshop.data.enums.UserRole;

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
