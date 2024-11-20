package com.dh.DentalClinicMvc;

import com.dh.DentalClinicMvc.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DentalClinicMvcApplication {

	public static void main(String[] args) {
		DB.createTables();
		SpringApplication.run(DentalClinicMvcApplication.class, args);
	}



}
