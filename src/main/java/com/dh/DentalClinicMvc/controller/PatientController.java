package com.dh.DentalClinicMvc.controller;

import com.dh.DentalClinicMvc.model.Patient;
import com.dh.DentalClinicMvc.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) throws Exception{
        return patientService.save(patient);
    }

    @PutMapping
    public void udated(@RequestBody Patient patient){
        patientService.update(patient);
    }

    @GetMapping
    public ResponseEntity<Patient> findById( @RequestParam Long id){
        Optional<Patient> optional = patientService.findById(id);
        if(optional.isPresent()){
          return   ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all")
    public List<Patient> findByAll(){
       return patientService.findAll();
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long id){
       patientService.deleteById(id);
    }


}
