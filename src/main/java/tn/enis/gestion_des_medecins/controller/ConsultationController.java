package tn.enis.gestion_des_medecins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.enis.gestion_des_medecins.entities.Consultation;
import tn.enis.gestion_des_medecins.repositories.ConsultationRepository;
import tn.enis.gestion_des_medecins.repositories.MedecinRepository;
import tn.enis.gestion_des_medecins.repositories.PatientRepository;

import java.util.List;

@RestController
public class ConsultationController {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MedecinRepository medecinRepository;
	
	@GetMapping(value="/consultations")
	@Secured({ "ROLE_ADMIN"})
	public List<Consultation> getAll(){
		return consultationRepository.findAll();
	}
	
	@GetMapping(value="/consult/{id}")
	@Secured({ "ROLE_ADMIN"})
	public Consultation findOne(@PathVariable Long id) {
		return consultationRepository.findById(id).get();
	}
	
	@PostMapping(value="/consult/save")
	@Secured({ "ROLE_ADMIN"})
	public Consultation save(@RequestBody Consultation consultation) {
		return consultationRepository.save(consultation);
	}
	
	@PutMapping(value="/consult/edit")
	@Secured({ "ROLE_ADMIN"})
	public Consultation edit(@RequestBody Consultation consultation) {
		return consultationRepository.save(consultation);
	}

	@DeleteMapping(value="/consult/delete/{id}")
	@Secured({ "ROLE_ADMIN"})
	public void delete(@PathVariable Long id) {
		consultationRepository.delete(consultationRepository.getOne(id));
	}

	@GetMapping(value="/patient/{id}/consults")
	@Secured({ "ROLE_ADMIN","ROLE_PATIENT"})
	public List<Consultation> listConsultsOfPatient(@PathVariable Long id){ return consultationRepository.listConsultsOfPatient(patientRepository.getOne(id));}

	@GetMapping(value="/medecin/{id}/consults")
	@Secured({ "ROLE_ADMIN","ROLE_MEDECIN"})
	public List<Consultation> listConsultsOfDoctor(@PathVariable Long id){ return consultationRepository.listConsultsOfDoctor(medecinRepository.getOne(id));}

}
