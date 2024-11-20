package com.dh.DentalClinicMvc.controller;

import com.dh.DentalClinicMvc.model.Dentist;
import com.dh.DentalClinicMvc.service.DentistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dentist")
public class DentistController {

    private DentistService dentistService;

    public DentistController (DentistService dentistService){
        this.dentistService = dentistService;
    }

    @GetMapping
    public String findDentistById(Model model, @RequestParam("id") int id){
        Dentist dentist = dentistService.findById(id);
        model.addAttribute("name", dentist.getName());
        model.addAttribute("lastname", dentist.getLastname());
        model.addAttribute("registration",dentist.getRegistration());
       return "indexDentist";
    }


}
