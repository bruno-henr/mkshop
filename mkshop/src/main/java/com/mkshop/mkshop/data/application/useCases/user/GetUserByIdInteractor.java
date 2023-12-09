package com.mkshop.mkshop.data.application.useCases.user;

import com.mkshop.mkshop.data.application.gateways.UserGateway;
import com.mkshop.mkshop.domain.entities.UserEntity;

import java.util.Optional;

public class GetUserByIdInteractor {
    private UserGateway userGateway;

    public GetUserByIdInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Optional<UserEntity> getUserById(String id) {
        return this.userGateway.getUserById(id);
    }
}
