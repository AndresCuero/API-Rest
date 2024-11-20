package com.dh.DentalClinicMvc.dao;

import java.util.List;

public interface IDao<T>{

    T save(T t) throws Exception;
    T findBYId(Integer id);
    void update(T t);
    void delete(Integer id);
    List<T> findAll();
    T findByString(String email);
}
