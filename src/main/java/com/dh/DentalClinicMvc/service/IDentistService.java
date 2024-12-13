package com.dh.DentalClinicMvc.service;


import com.dh.DentalClinicMvc.entity.Dentist;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;

import java.util.List;
import java.util.Optional;


public interface IDentistService {

    Dentist save(Dentist dentist);
    void update(Dentist dentist);
    void deleteById(Long id) throws ResourceNotFoundExeception;
    Optional<Dentist> findById(Long id);
    List<Dentist> findAll();
    Optional<Dentist> findByRegistration(Integer registration);

}
