package com.mkshop.mkshop.data.application.gateways;

import com.mkshop.mkshop.data.infrastructure.model.User;
import com.mkshop.mkshop.domain.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    UserEntity createUser(UserEntity user);
    UserEntity editUser(String id, UserEntity user);
    String deleteUser(String id);
    List<UserEntity> getAllUser();

    Optional<UserEntity> getUserById(String id);

    UserDetails getUserByUsername(String username);

}
