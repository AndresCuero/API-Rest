package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.dao.AddressDaoh2;
import com.dh.DentalClinicMvc.dao.IDao;
import com.dh.DentalClinicMvc.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {

    private IDao<Address> addressIDao;

    public AddressService(){
        this.addressIDao = new AddressDaoh2();
    }

    public Address save(Address address) throws Exception{
        return addressIDao.save(address);
    }

    public Address findById(Integer id){
        return addressIDao.findBYId(id);
    }

    public void updated(Address address){
         addressIDao.update(address);
    }

    public void delete(Integer id){
        addressIDao.delete(id);
    }

    public List<Address> findAll(){
        return addressIDao.findAll();
    }
}
