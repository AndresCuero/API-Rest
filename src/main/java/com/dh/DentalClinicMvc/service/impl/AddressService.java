package com.dh.DentalClinicMvc.service.impl;

import com.dh.DentalClinicMvc.Repository.AddressRepository;
import com.dh.DentalClinicMvc.model.Address;
import com.dh.DentalClinicMvc.service.IAdrressSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAdrressSerivice {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public Address save(Address address){
        return addressRepository.save(address);
    }

    @Override
    public void update(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }


    @Override
    public Optional<Address> findById(Long id){
        return addressRepository.findById(id);
    }
    @Override
    public List<Address> findAll(){
        return addressRepository.findAll();
    }
}
