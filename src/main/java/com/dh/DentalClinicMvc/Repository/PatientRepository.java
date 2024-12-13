package com.dh.DentalClinicMvc.Repository;

import com.dh.DentalClinicMvc.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
