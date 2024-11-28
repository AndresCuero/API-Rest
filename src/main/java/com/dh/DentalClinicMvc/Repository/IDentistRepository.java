package com.dh.DentalClinicMvc.Repository;

import com.dh.DentalClinicMvc.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository extends JpaRepository<Dentist, Long> {

}
