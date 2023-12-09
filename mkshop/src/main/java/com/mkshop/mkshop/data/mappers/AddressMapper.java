package com.mkshop.mkshop.data.mappers;

import com.mkshop.mkshop.domain.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(com.mkshop.mkshop.data.infrastructure.model.Address address) {
        return new Address(
                address.getNeighborhood(),
                address.getStreet(),
                address.getNumber(),
                address.getId()
        );
    }

    public com.mkshop.mkshop.data.infrastructure.model.Address toModel(
            Address address
    ) {
        return new com.mkshop.mkshop.data.infrastructure.model.Address(
                address.neighborhood(),
                address.street(),
                address.number()
        );
    }
}
