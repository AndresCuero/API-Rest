package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.model.Address;
import com.dh.DentalClinicMvc.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface IDentistService {

    Dentist save(Dentist dentist);
    void update(Dentist dentist);
    void deleteById(Long id);
    Optional<Dentist> findById(Long id);
    List<Dentist> findAll();

}
