package com.dh.DentalClinicMvc.service;



import com.dh.DentalClinicMvc.dto.AppointmentDTO;
import com.dh.DentalClinicMvc.entity.Appointment;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {

    AppointmentDTO save (AppointmentDTO appointmentDTO);
    Optional<AppointmentDTO> findById(Long id);
    AppointmentDTO update(AppointmentDTO appointmentDTO) throws Exception;
    Optional<AppointmentDTO> delete(Long id) throws ResourceNotFoundExeception;
    List<AppointmentDTO> findAll();
}
