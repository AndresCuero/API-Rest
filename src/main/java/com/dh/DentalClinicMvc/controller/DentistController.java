package com.dh.DentalClinicMvc.controller;

import com.dh.DentalClinicMvc.entity.Dentist;
import com.dh.DentalClinicMvc.exeception.ResourceNotFoundExeception;
import com.dh.DentalClinicMvc.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class DentistController {

    private IDentistService iDentistService;

    @Autowired
    public DentistController(IDentistService iDentistService) {
        this.iDentistService = iDentistService;
    }

    //localhost:8080/dentist/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Long id) {
        Optional<Dentist> dentist = iDentistService.findById(id);

        if (dentist.isPresent()) {
            return ResponseEntity.ok(dentist.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //vamos a guardar un nuevo odontólogo en la BD
    @PostMapping
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) {
        return ResponseEntity.ok(iDentistService.save(dentist));
    }

    //vamos a actualizar los datos de un odontologo
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Dentist dentist) {
        ResponseEntity<String> response;
        Optional<Dentist> dentistToLookFor = iDentistService.findById(dentist.getId());

        if (dentistToLookFor.isPresent()) {
            iDentistService.update(dentist);
            response = ResponseEntity.ok("Se actualizó el odontólogo con nombre: " + dentist.getName());

        } else {
            response = ResponseEntity.ok().body("No se puede actualizar un odontólogo que no existe en la base de datos");
        }
        return response;
    }

    //vamos a borrar un odontólogo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundExeception {
      iDentistService.deleteById(id);
      return ResponseEntity.ok("Se elimino corretamente el id "+id);
    }

    //vamos a listar todos los odontólogos
    @GetMapping
    public ResponseEntity<List<Dentist>> findAll() {
        return ResponseEntity.ok(iDentistService.findAll());
    }

   @GetMapping("/registration/{registration}")
    public ResponseEntity<Dentist> findByRegistration(@PathVariable Integer registration) throws Exception {
        Optional<Dentist> dentist = iDentistService.findByRegistration(registration);
        if(!dentist.isPresent()){
            throw new Exception("No se encontro la matricula "+registration);
        }
       return ResponseEntity.ok(dentist.get());
    }
}
