package com.dh.DentalClinicMvc.service;

import com.dh.DentalClinicMvc.entity.User;

import java.util.List;

public interface IUserService {

    User saver(User user);
    void update(Long id);
    void deleteById(Long id);
    User findById(Long id);
    List<User> findAll();
}
