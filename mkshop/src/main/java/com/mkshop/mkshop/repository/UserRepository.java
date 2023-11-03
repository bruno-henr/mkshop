package com.mkshop.mkshop.repository;

import com.mkshop.mkshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
