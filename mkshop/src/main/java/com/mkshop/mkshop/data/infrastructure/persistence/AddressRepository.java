package com.mkshop.mkshop.data.infrastructure.persistence;

import com.mkshop.mkshop.data.infrastructure.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {

}
