package com.mkshop.mkshop.data.infrastructure.controllers.address;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.address.CreateAddressInteractor;
import com.mkshop.mkshop.domain.entities.Address;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAddressController {
    private final CreateAddressInteractor createAddressInteractor;

    public CreateAddressController(CreateAddressInteractor createAddressInteractor) {
        this.createAddressInteractor = createAddressInteractor;
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseAPI<Address>> addAddress(@RequestBody @Valid Address address) {
        try {
            Address addressSaved = this.createAddressInteractor.createAddress(address);
            return new ResponseEntity<>(
                    new ResponseAPI<>(addressSaved, false, HttpStatus.CREATED.value(), null),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
