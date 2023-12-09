package com.mkshop.mkshop.data.application.useCases.user;

import com.mkshop.mkshop.data.application.gateways.UserGateway;
import com.mkshop.mkshop.domain.entities.UserEntity;

public class EditUserInteractor {
    private UserGateway userGateway;

    public EditUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public UserEntity editUser(String id, UserEntity user) {
        return this.userGateway.editUser(id, user);
    }
}
