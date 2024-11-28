package com.dh.DentalClinicMvc.Repository;

import com.dh.DentalClinicMvc.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
