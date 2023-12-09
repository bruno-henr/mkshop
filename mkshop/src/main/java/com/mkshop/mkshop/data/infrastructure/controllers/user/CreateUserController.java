package com.mkshop.mkshop.data.infrastructure.controllers.user;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.user.CreateUserInteractor;
import com.mkshop.mkshop.domain.entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {
    private final CreateUserInteractor createUserInteractor;

    public CreateUserController(CreateUserInteractor createUserInteractor) {
        this.createUserInteractor = createUserInteractor;
    }

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<UserEntity>> addUser(
            @RequestBody @Valid UserEntity user
    ) {
        try {
            UserEntity userSaved = this.createUserInteractor.createUser(user);
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            userSaved, false, HttpStatus.CREATED.value(), null
                    ), HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null, true, HttpStatus.BAD_REQUEST.value(), e.toString()
                    ), HttpStatus.BAD_REQUEST
            );
        }
    }
}
