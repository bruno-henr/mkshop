package com.mkshop.mkshop.data.infrastructure.controllers.user;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.user.DeleteUserInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserByIdController {
    private final DeleteUserInteractor deleteUserInteractor;

    public DeleteUserByIdController(DeleteUserInteractor deleteUserInteractor) {
        this.deleteUserInteractor = deleteUserInteractor;
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> deleteUser(
            @PathVariable String id
    ) {
        try {
            this.deleteUserInteractor.deleteUserById(id);
            return new ResponseEntity(
                    new ResponseAPI<String>(
                            "Usuário removido com sucesso.",
                            false,
                            HttpStatus.OK.value(),
                            null
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            "Erro ao excluir usuario",
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
