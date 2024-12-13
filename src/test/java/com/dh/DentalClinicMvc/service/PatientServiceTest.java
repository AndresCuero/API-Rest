package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.entity.Patient;
import com.dh.DentalClinicMvc.service.impl.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    void findById() {
        Long idPatient = 3L;

        Optional< Patient> patient = patientService.findById(idPatient);
        assertNotNull(patient);
    }


}