package com.mkshop.mkshop.data.application.gateways;

import com.mkshop.mkshop.domain.entities.Address;

import java.util.List;

public interface AddressGateway {
    Address createAddress(Address address);
    Address editAddress(String id, Address address);
    String deleteAddressById(String id);
    List<Address> getAllAddress();
    Address getAddressById(String id);
}
