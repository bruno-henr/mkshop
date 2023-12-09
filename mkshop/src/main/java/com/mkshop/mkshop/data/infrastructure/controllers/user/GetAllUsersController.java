package com.mkshop.mkshop.data.infrastructure.controllers.user;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.user.GetAllUsersInteractor;
import com.mkshop.mkshop.domain.entities.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllUsersController {
    private final GetAllUsersInteractor getAllUsersInteractor;

    public GetAllUsersController(GetAllUsersInteractor getAllUsersInteractor) {
        this.getAllUsersInteractor = getAllUsersInteractor;
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<List<UserEntity>>> getAllUser() {
        try {
            List<UserEntity> allUsers = this.getAllUsersInteractor.getAllUsers();

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            allUsers,
                            false,
                            HttpStatus.OK.value(),
                            null
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
