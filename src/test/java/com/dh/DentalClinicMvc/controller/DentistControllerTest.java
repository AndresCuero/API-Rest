package com.dh.DentalClinicMvc.controller;

import com.dh.DentalClinicMvc.entity.Dentist;
import com.dh.DentalClinicMvc.service.IDentistService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DentistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IDentistService dentistService;


    public void dataLoad(){
        Dentist dentist = new Dentist();
        dentist.setRegistration(43434);
        dentist.setName("Andres");
        dentist.setLastName("Muelas");
        dentistService.save(dentist);
    }

    @Test
    @Order(2)
    public void testGetDentistById() throws Exception {
        dataLoad();
        mockMvc.perform(get("/odontologos/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registration").value("43434"))
                .andExpect(jsonPath("$.name").value("Andres"))
                .andExpect(jsonPath("$.lastName").value("Muelas"));
    }

    @Test
    @Order(3)
    public void testPostDentist() throws Exception {
        String dentistSaved = "{ \"registration\": \"12345\", \"name\": \"juan\", \"lastName\": \"sinisterra\"}";

        mockMvc.perform(post("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dentistSaved)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registration").value("12345"))
                .andExpect(jsonPath("$.name").value("juan"))
                .andExpect(jsonPath("$.lastName").value("sinisterra"));

    }

    @Test
    @Order(1)
    public void testGetAllDentist() throws Exception {
        mockMvc.perform(get("/odontologos"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

    }


}