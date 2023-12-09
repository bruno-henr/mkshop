package com.mkshop.mkshop.data.application.useCases.address;

import com.mkshop.mkshop.data.application.gateways.AddressGateway;
import com.mkshop.mkshop.domain.entities.Address;

import java.util.List;

public class GetAllAddressInteractor {

    private AddressGateway addressGateway;

    public GetAllAddressInteractor(AddressGateway addressGateway){
        this.addressGateway = addressGateway;
    }

    public List<Address> getAllAddress() {
        return this.addressGateway.getAllAddress();
    }
}
