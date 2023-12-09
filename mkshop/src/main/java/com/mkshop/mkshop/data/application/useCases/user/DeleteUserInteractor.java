package com.mkshop.mkshop.data.application.useCases.user;

import com.mkshop.mkshop.data.application.gateways.UserGateway;

public class DeleteUserInteractor {
    private UserGateway userGateway;

    public DeleteUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public String deleteUserById(String id) {
        return this.userGateway.deleteUser(id);
    }
}
