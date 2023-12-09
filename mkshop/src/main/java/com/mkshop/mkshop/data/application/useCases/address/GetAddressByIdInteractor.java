package com.mkshop.mkshop.data.application.useCases.address;

import com.mkshop.mkshop.data.application.gateways.AddressGateway;
import com.mkshop.mkshop.domain.entities.Address;

public class GetAddressByIdInteractor {
    private AddressGateway addressGateway;

    public GetAddressByIdInteractor(AddressGateway addressGateway){
        this.addressGateway = addressGateway;
    }

    public Address getAddressById(String id) {
        return this.addressGateway.getAddressById(id);
    }
}
