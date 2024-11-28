package com.dh.DentalClinicMvc.service.impl;

import com.dh.DentalClinicMvc.Repository.IDentistRepository;
import com.dh.DentalClinicMvc.model.Dentist;
import com.dh.DentalClinicMvc.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DentistService implements IDentistService {

    private final IDentistRepository iDentistRepository;

    @Autowired
    public DentistService(IDentistRepository iDentistRepository) {
        this.iDentistRepository = iDentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return null;
    }

    @Override
    public void update(Dentist dentist) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Dentist> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Dentist> findAll() {
        return List.of();
    }
}
