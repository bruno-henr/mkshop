package com.mkshop.mkshop.data.infrastructure.controllers.user;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.user.EditUserInteractor;
import com.mkshop.mkshop.domain.entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EditUserController {
    private final EditUserInteractor editUserInteractor;

    public EditUserController(EditUserInteractor editUserInteractor) {
        this.editUserInteractor = editUserInteractor;
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<UserEntity>> editUser(
            @PathVariable String id, @RequestBody @Valid UserEntity user
    ) {
        try {
            UserEntity userSaved = this.editUserInteractor.editUser(id, user);
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            userSaved,
                            false,
                            HttpStatus.OK.value(),
                            null
                    ), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null,
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ), HttpStatus.BAD_REQUEST
            );
        }
    }
}