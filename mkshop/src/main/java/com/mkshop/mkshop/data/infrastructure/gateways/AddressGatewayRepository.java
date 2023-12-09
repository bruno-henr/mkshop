package com.mkshop.mkshop.data.infrastructure.gateways;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.application.gateways.AddressGateway;
import com.mkshop.mkshop.data.infrastructure.persistence.AddressRepository;
import com.mkshop.mkshop.data.mappers.AddressMapper;
import com.mkshop.mkshop.domain.entities.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class AddressGatewayRepository implements AddressGateway {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    public AddressGatewayRepository(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address createAddress(Address address) {
        com.mkshop.mkshop.data.infrastructure.model.Address addressSaved =
                this.addressRepository.save(
                        this.addressMapper.toModel(address)
                );
        return this.addressMapper.toEntity(addressSaved);
    }

    @Override
    public Address editAddress(String id, Address address) {
        return this.addressRepository.findById(id).map(a -> {
            a.setNeighborhood(address.neighborhood() != null ? address.neighborhood() : a.getNeighborhood());
            a.setStreet(address.street() != null ? address.street() : a.getStreet());
            a.setNumber(address.number() != null ? address.number() : a.getNumber());
            this.addressRepository.save(a);

            return this.addressMapper.toEntity(a);
        }).orElseGet(() -> {
            com.mkshop.mkshop.data.infrastructure.model.Address addressSaved = this.addressRepository.save(
                    this.addressMapper.toModel(address)
            );

            return this.addressMapper.toEntity(addressSaved);
        });
    }

    @Override
    public String deleteAddressById(String id) {
        this.addressRepository.deleteById(id);
        return "Endereço removido com sucesso.";
    }

    @Override
    public List<Address> getAllAddress() {
        return this.addressRepository
                .findAll()
                .stream()
                .map(address -> this.addressMapper.toEntity(address))
                .toList();
    }

    @Override
    public Address getAddressById(String id) {
        Optional<com.mkshop.mkshop.data.infrastructure.model.Address> addressOptional = this.addressRepository.findById(id);
        return addressOptional.map(address -> this.addressMapper.toEntity(address)).orElse(null);
    }
}
