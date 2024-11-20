package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.dao.DentistDaoh2;
import com.dh.DentalClinicMvc.dao.IDao;
import com.dh.DentalClinicMvc.model.Dentist;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DentistService {

    private IDao<Dentist> dentistIDao;

    public DentistService(){
        this.dentistIDao = new DentistDaoh2();
    }

    public Dentist save(Dentist dentist) throws Exception{
        return dentistIDao.save(dentist);
    }

    public Dentist findById(Integer id){
        return dentistIDao.findBYId(id);
    }

    public void updated(Dentist dentist){
        dentistIDao.update(dentist);
    }

    public void delete(Integer id){
        dentistIDao.delete(id);
    }

    public List<Dentist> findAll(){
        return dentistIDao.findAll();
    }
}
