package com.dh.DentalClinicMvc.Repository;

import com.dh.DentalClinicMvc.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    @Query("SELECT m from Dentist m where m.registration =?1")
    Optional<Dentist> findByRegistration(Integer registration);
}
