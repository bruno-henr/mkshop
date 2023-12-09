package com.mkshop.mkshop.data.infrastructure.controllers.address;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.address.DeleteAddressByIdInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAddressByIdController {
    private final DeleteAddressByIdInteractor deleteAddressByIdInteractor;

    public DeleteAddressByIdController(DeleteAddressByIdInteractor deleteAddressByIdInteractor) {
        this.deleteAddressByIdInteractor = deleteAddressByIdInteractor;
    }

    @DeleteMapping("/address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> deleteById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(
                    new ResponseAPI<String>(
                            this.deleteAddressByIdInteractor.deleteAddressById(id),
                            false,
                            HttpStatus.OK.value(), null
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            "Erro ao excluir endereço.",
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
