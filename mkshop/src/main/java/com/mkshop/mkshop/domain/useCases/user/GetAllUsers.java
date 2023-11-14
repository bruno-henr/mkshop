package com.mkshop.mkshop.domain.useCases.user;

import com.mkshop.mkshop.domain.entities.User;
import com.mkshop.mkshop.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUser {
    @Autowired
    private IUserRepository userRepository;

    public User createUser(User user) {
        return this.userRepository.createUser(user);
    }
}
