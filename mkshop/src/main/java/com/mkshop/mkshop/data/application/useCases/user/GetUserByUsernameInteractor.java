package com.mkshop.mkshop.data.application.useCases.user;

import com.mkshop.mkshop.data.application.gateways.UserGateway;
import org.springframework.security.core.userdetails.UserDetails;

public class GetUserByUsernameInteractor {
    private UserGateway userGateway;

    public GetUserByUsernameInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public UserDetails getUserByUsername(String username) {
        return this.userGateway.getUserByUsername(username);
    }
}
