package com.dh.DentalClinicMvc.Repository;

import com.dh.DentalClinicMvc.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}
