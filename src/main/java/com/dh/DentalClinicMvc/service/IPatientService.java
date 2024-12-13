package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.entity.Patient;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;

import java.util.List;
import java.util.Optional;


public interface IPatientService {

    Patient save(Patient patient);
    void update(Patient patient);
    void deleteById(Long id) throws ResourceNotFoundExeception;
    Optional<Patient> findById(Long id);
    List<Patient> findAll();
}
