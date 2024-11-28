package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.model.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    Patient save(Patient patient);
    void update(Patient patient);
    void deleteById(Long id);
    Optional<Patient> findById(Long id);
    List<Patient> findAll();
}
