package tn.enis.gestion_des_medecins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.gestion_des_medecins.repositories.PatientRepository;
import tn.enis.gestion_des_medecins.entities.Patient;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> findMedecins() {
        return patientRepository.findAll();
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public Patient findOneMedecin(@PathVariable Long id) {
        return patientRepository.findById(id).get();
    }

    @PostMapping(value="/savepatient")
    public Patient saveMedecin(@RequestBody Patient medecin) {
        return patientRepository.save(medecin);
    }
}
