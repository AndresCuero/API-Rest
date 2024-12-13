package com.dh.DentalClinicMvc.service.impl;

import com.dh.DentalClinicMvc.Repository.IAppointmentRepository;
import com.dh.DentalClinicMvc.dto.AppointmentDTO;
import com.dh.DentalClinicMvc.entity.Appointment;
import com.dh.DentalClinicMvc.entity.Dentist;
import com.dh.DentalClinicMvc.entity.Patient;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;
import com.dh.DentalClinicMvc.service.IAppointmentService;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {

    private IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {

        Appointment appointmentEntity = new Appointment();

        //Patient
        Patient patientEntity = new Patient();
        patientEntity.setId(appointmentDTO.getPatient_id());

        //Dentist
        Dentist dentistEntity = new Dentist();
        dentistEntity.setId(appointmentDTO.getDentist_id());

        appointmentEntity.setPatient(patientEntity);
        appointmentEntity.setDentist(dentistEntity);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(appointmentDTO.getDate(), formatter);

        appointmentEntity.setDate(date);

        appointmentRepository.save(appointmentEntity);

        AppointmentDTO appointmentDTORoturn = new AppointmentDTO();
        appointmentDTORoturn.setId(appointmentEntity.getId());
        appointmentDTORoturn.setPatient_id(appointmentEntity.getPatient().getId());
        appointmentDTORoturn.setDentist_id(appointmentEntity.getDentist().getId());
        appointmentDTORoturn.setDate(appointmentEntity.getDate().toString());

        return appointmentDTORoturn;
    }

    @Override
    public Optional<AppointmentDTO> findById(Long id) {

        Optional<Appointment> appointmentToLookFor = appointmentRepository.findById(id);
        Optional<AppointmentDTO> appointmentDTOReturn = null;

        if (appointmentToLookFor.isPresent()){

            Appointment appointment = appointmentToLookFor.get();

            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setId(appointment.getId());
            appointmentDTO.setPatient_id(appointment.getPatient().getId());
            appointmentDTO.setDentist_id(appointment.getDentist().getId());
            appointmentDTO.setDate(appointment.getDate().toString());
            appointmentDTOReturn = Optional.of(appointmentDTO);
        }
        return appointmentDTOReturn;
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) throws EntityNotFoundException {

       Optional<Appointment> appointmentExists = appointmentRepository.findById(appointmentDTO.getId());
       if(appointmentExists.isPresent()) {

           Appointment appointmentEntity = appointmentExists.get();


           //patient
           Patient patientEntity = new Patient();
           patientEntity.setId(appointmentDTO.getPatient_id());
           appointmentEntity.setPatient(patientEntity);

           //Dentist
           Dentist dentistEntity = new Dentist();
           dentistEntity.setId(appointmentDTO.getId());
           appointmentEntity.setDentist(dentistEntity);

           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           LocalDate date = LocalDate.parse(appointmentDTO.getDate(), formatter);

           appointmentEntity.setDate(date);

           appointmentRepository.save(appointmentEntity);

           return new AppointmentDTO(
                   appointmentEntity.getId(),
                   appointmentEntity.getPatient().getId(),
                   appointmentEntity.getDentist().getId(),
                   appointmentEntity.getDate().toString()
           );
       }else {
           throw new EntityNotFoundException("Error, la cita no existe");
        }

    }


    @Override
    public Optional<AppointmentDTO> delete(Long id) throws ResourceNotFoundExeception {
      appointmentRepository.deleteById(id);

      Optional<Appointment> appointmentToLookFor = appointmentRepository.findById(id);

      Optional<AppointmentDTO> appointmentDTO;
      if(appointmentToLookFor.isPresent()){
          Appointment appointment = new Appointment();

          AppointmentDTO appointmentDTOToReturn = new AppointmentDTO();
          appointmentDTOToReturn.setId(appointment.getId());
          appointmentDTOToReturn.setDentist_id(appointment.getDentist().getId());
          appointmentDTOToReturn.setPatient_id(appointment.getPatient().getId());
          appointmentDTOToReturn.setDate(appointment.getDate().toString());
          appointmentDTO = Optional.of(appointmentDTOToReturn);
          return appointmentDTO;
      }else{
          throw new ResourceNotFoundExeception("No se encontro el turno con id: "+ id);
      }
    }

    @Override
    public List<AppointmentDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        for(Appointment appointment : appointments){
            AppointmentDTO dto = new  AppointmentDTO(
                    appointment.getId(),
                    appointment.getPatient().getId(),
                    appointment.getDentist().getId(),
                    appointment.getDate().toString()
            );
            appointmentDTOS.add(dto);
        }
        return appointmentDTOS;
    }
}
