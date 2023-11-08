package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByCpf(String cpf);

    UserDetails findByUsername(String username);
}
