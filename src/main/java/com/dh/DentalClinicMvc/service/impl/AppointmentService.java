package com.dh.DentalClinicMvc.service.impl;

import com.dh.DentalClinicMvc.Repository.IAppointmentRepository;
import com.dh.DentalClinicMvc.model.Appointment;
import com.dh.DentalClinicMvc.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AppointmentService implements IAppointmentService {

    private IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void update(Appointment appointment) {
       appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Long id) {
      appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}
