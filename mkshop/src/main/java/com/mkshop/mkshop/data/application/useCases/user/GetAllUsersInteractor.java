package com.mkshop.mkshop.data.application.useCases.user;

import com.mkshop.mkshop.data.application.gateways.UserGateway;
import com.mkshop.mkshop.domain.entities.UserEntity;

import java.util.List;

public class GetAllUsersInteractor {
    private UserGateway userGateway;

    public GetAllUsersInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<UserEntity> getAllUsers() {
        return this.userGateway.getAllUser();
    }
}
