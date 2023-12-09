package com.mkshop.mkshop.data.infrastructure.controllers.user;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.user.GetUserByUsernameInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserByUsernameController {
    private final GetUserByUsernameInteractor getUserByUsernameInteractor;

    public GetUserByUsernameController(GetUserByUsernameInteractor getUserByUsernameInteractor) {
        this.getUserByUsernameInteractor = getUserByUsernameInteractor;
    }

    @GetMapping("/user/username")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<UserDetails>> getUserByUsername(
            @RequestParam(value = "username") String username
    ) {
        UserDetails user = this.getUserByUsernameInteractor.getUserByUsername(username);

        return new ResponseEntity<>(
                new ResponseAPI<>(user, false, HttpStatus.OK.value(), null),
                HttpStatus.OK
        );
    }
}
