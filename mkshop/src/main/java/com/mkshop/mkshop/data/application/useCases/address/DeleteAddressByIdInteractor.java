package com.mkshop.mkshop.data.application.useCases.address;

import com.mkshop.mkshop.data.application.gateways.AddressGateway;
import com.mkshop.mkshop.domain.entities.Address;

public class DeleteAddressByIdInteractor {
    private AddressGateway addressGateway;

    public DeleteAddressByIdInteractor(AddressGateway addressGateway){
        this.addressGateway = addressGateway;
    }

    public String deleteAddressById(String id) {
        return this.addressGateway.deleteAddressById(id);
    }
}
