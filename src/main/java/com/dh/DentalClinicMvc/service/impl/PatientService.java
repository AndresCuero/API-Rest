package com.dh.DentalClinicMvc.service.impl;

import com.dh.DentalClinicMvc.Repository.PatientRepository;
import com.dh.DentalClinicMvc.entity.Patient;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;
import com.dh.DentalClinicMvc.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {



        private PatientRepository patientRepository;

        @Autowired
        public PatientService(PatientRepository patientRepository) {
            this.patientRepository = patientRepository;
        }

        public Patient save(Patient patient) {
            return patientRepository.save(patient);
        }

        public Optional<Patient> findById(Long id) {
            return patientRepository.findById(id);
        }

        public void deleteById(Long id) throws ResourceNotFoundExeception {
            Optional<Patient> patient = patientRepository.findById(id);
            if(patient.isPresent()){
                patientRepository.deleteById(id);
            }else{
                throw new ResourceNotFoundExeception("No se encontro el id "+ id);
            }
        }

        public List<Patient> findAll() {
            return patientRepository.findAll();
        }

        public void update(Patient patient) {
            patientRepository.save(patient);

        }
    }


