package com.mkshop.mkshop.data.controller;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.infrastructure.model.Address;
import com.mkshop.mkshop.data.infrastructure.persistence.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController
public class AddressController {
//    @Autowired
//    private AddressRepository addressRepository;
//
//
//    @GetMapping("/address/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<Optional<Address>>> getAddressById(@PathVariable String id) {
//        try {
//            Optional<Address> address = this.addressRepository.findById(id);
//
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(address, false, HttpStatus.OK.value(), null),
//                    HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }
//
//    @PostMapping("/address")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<ResponseAPI<Address>> addAddress(@RequestBody Address address) {
//        try {
//            Address addressSaved = this.addressRepository.save(address);
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(addressSaved, false, HttpStatus.CREATED.value(), null),
//                    HttpStatus.CREATED
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }
//
//    @PutMapping("/address/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<Address>> editAddress(@RequestBody Address address, @PathVariable String id) {
//        try {
//            return this.addressRepository.findById(id).map(a -> {
//                a.setNeighborhood(address.getNeighborhood());
//                a.setStreet(address.getStreet());
//                a.setNumber(address.getNumber());
//                this.addressRepository.save(a);
//
//                return new ResponseEntity<>(
//                        new ResponseAPI<>(a, false, HttpStatus.OK.value(), null),
//                        HttpStatus.OK
//                );
//            }).orElseGet(() -> {
//                Address addressSaved = this.addressRepository.save(address);
//
//                return new ResponseEntity<>(
//                        new ResponseAPI<>(addressSaved, false, HttpStatus.CREATED.value(), null),
//                        HttpStatus.CREATED
//                );
//            });
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, false, HttpStatus.CREATED.value(), e.toString()),
//                    HttpStatus.CREATED
//            );
//        }
//    }
//
//    @DeleteMapping("/address/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<String>> deleteById(@PathVariable String id) {
//        try {
//            this.addressRepository.deleteById(id);
//            return new ResponseEntity<>(
//                    new ResponseAPI<String>(
//                            "Endereço removido com sucesso.",
//                            false,
//                            HttpStatus.OK.value(), null),
//                    HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            "Erro ao excluir endereço.",
//                            true,
//                            HttpStatus.BAD_REQUEST.value(),
//                            e.toString()
//                    ),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }
}
