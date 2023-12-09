package com.mkshop.mkshop.data.infrastructure.controllers.user;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.user.GetUserByIdInteractor;
import com.mkshop.mkshop.domain.entities.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetUserByIdController {
    private final GetUserByIdInteractor getUserByIdInteractor;

    public GetUserByIdController(GetUserByIdInteractor getUserByIdInteractor) {
        this.getUserByIdInteractor = getUserByIdInteractor;
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Optional<UserEntity>>> getUserById(
            @PathVariable String id
    ) {
        try {
            Optional<UserEntity> user = this.getUserByIdInteractor.getUserById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            user,
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
