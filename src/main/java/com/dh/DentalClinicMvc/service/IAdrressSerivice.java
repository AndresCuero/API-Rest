package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAdrressSerivice {

    Address save(Address address);
    void update(Address address);
    void deleteById(Long id);
    Optional<Address> findById(Long id);
    List<Address> findAll();
}
