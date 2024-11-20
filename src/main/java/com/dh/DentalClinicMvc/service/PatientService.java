package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.dao.IDao;
import com.dh.DentalClinicMvc.dao.PatientDaoh2;
import com.dh.DentalClinicMvc.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {

    private IDao<Patient> patientIDao;

    public PatientService(){
        this.patientIDao = new PatientDaoh2();
    }

    public Patient save(Patient patient) throws Exception{
        return patientIDao.save(patient);
    }

    public Patient findById(Integer id) {
        return patientIDao.findBYId(id);
    }

    public void update(Patient patient) {
        patientIDao.update(patient);
    }

    public void delete(Integer id){
        patientIDao.delete(id);
    }

    public List<Patient> findAll(){
        return patientIDao.findAll();
    }

    public  Patient findByEmail(String email){
        return patientIDao.findByString(email);
    }
}
