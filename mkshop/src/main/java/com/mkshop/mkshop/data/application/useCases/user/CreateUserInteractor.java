package com.mkshop.mkshop.data.application.useCases.user;

import com.mkshop.mkshop.data.application.gateways.UserGateway;
import com.mkshop.mkshop.domain.entities.UserEntity;

public class CreateUserInteractor {

    private UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public UserEntity createUser(UserEntity user) {
        return this.userGateway.createUser(user);
    }
}
