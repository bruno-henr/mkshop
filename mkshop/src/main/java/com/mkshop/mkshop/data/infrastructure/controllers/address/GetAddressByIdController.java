package com.mkshop.mkshop.data.infrastructure.controllers.address;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.address.GetAddressByIdInteractor;
import com.mkshop.mkshop.data.application.useCases.address.GetAllAddressInteractor;
import com.mkshop.mkshop.data.infrastructure.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetAddressByIdController {
    private final GetAddressByIdInteractor addressByIdInteractor;

    public GetAddressByIdController(GetAddressByIdInteractor addressByIdInteractor) {
        this.addressByIdInteractor = addressByIdInteractor;
    }

    @GetMapping("/address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<com.mkshop.mkshop.domain.entities.Address>> getAddressById(@PathVariable String id) {
        try {
            com.mkshop.mkshop.domain.entities.Address address = this.addressByIdInteractor.getAddressById(id);

            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            address,
                            false,
                            HttpStatus.OK.value(),
                            null
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            null,
                            true,
                            HttpStatus.BAD_REQUEST.value(),
                            e.toString()
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
