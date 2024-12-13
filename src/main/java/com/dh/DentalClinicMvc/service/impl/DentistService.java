package com.dh.DentalClinicMvc.service.impl;

import com.dh.DentalClinicMvc.Repository.IDentistRepository;
import com.dh.DentalClinicMvc.entity.Dentist;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;
import com.dh.DentalClinicMvc.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDentistService {

    private final IDentistRepository iDentistRepository;

    @Autowired
    public DentistService(IDentistRepository iDentistRepository) {
        this.iDentistRepository = iDentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return iDentistRepository.save(dentist);
    }

    @Override
    public void update(Dentist dentist) {
        iDentistRepository.save(dentist);

    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundExeception {
        Optional<Dentist> dentistReturn = iDentistRepository.findById(id);
        if(dentistReturn.isPresent()){
           iDentistRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundExeception("No se encontro el id "+ id);
        }
    }

    @Override
    public Optional<Dentist> findById(Long id) {
        return iDentistRepository.findById(id);
    }

    @Override
    public List<Dentist> findAll() {
        return iDentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> findByRegistration(Integer registration) {
        return iDentistRepository.findByRegistration(registration);
    }
}
