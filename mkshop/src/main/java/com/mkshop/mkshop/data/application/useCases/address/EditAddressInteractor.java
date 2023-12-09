package com.mkshop.mkshop.data.application.useCases.address;

import com.mkshop.mkshop.data.application.gateways.AddressGateway;
import com.mkshop.mkshop.domain.entities.Address;

public class EditAddressInteractor {
    private AddressGateway addressGateway;

    public EditAddressInteractor(AddressGateway addressGateway){
        this.addressGateway = addressGateway;
    }

    public Address editAddress(String id, Address address) {
        return this.addressGateway.editAddress(id, address);
    }
}
