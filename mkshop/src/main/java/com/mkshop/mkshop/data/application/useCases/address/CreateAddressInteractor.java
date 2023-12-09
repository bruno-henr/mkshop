package com.mkshop.mkshop.data.application.useCases.address;

import com.mkshop.mkshop.data.application.gateways.AddressGateway;
import com.mkshop.mkshop.domain.entities.Address;

public class CreateAddressInteractor {
    private AddressGateway addressGateway;

    public CreateAddressInteractor(AddressGateway addressGateway){
        this.addressGateway = addressGateway;
    }

    public Address createAddress(Address address) {
        return this.addressGateway.createAddress(address);
    }
}
