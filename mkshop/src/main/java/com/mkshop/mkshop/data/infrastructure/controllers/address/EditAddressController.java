package com.mkshop.mkshop.data.infrastructure.controllers.address;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.useCases.address.EditAddressInteractor;
import com.mkshop.mkshop.domain.entities.Address;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EditAddressController {
    private final EditAddressInteractor editAddressInteractor;

    public EditAddressController(EditAddressInteractor editAddressInteractor) {
        this.editAddressInteractor = editAddressInteractor;
    }

    @PutMapping("/address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<Address>> editAddress(
            @RequestBody @Valid Address address, @PathVariable String id
    ) {
        try {
            Address addressEdited = this.editAddressInteractor.editAddress(id, address);
            return new ResponseEntity<>(
                    new ResponseAPI<>(
                            addressEdited,
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
