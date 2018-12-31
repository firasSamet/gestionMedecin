package tn.enis.gestion_des_medecins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.enis.gestion_des_medecins.repositories.ConsultationRepository;
import tn.enis.gestion_des_medecins.entities.Consultation;

@RestController
public class ConsultationController {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	@GetMapping(value="/consultations")
	public List<Consultation> getAll(){
		return consultationRepository.findAll();
	}
	
	@GetMapping(value="/consultation/{id}")
	public Consultation findOne(@PathVariable Long id) {
		return consultationRepository.findById(id).get();
	}
	
	@PostMapping(value="/saveconsultation")
	public Consultation save(@RequestBody Consultation consultation) {
		return consultationRepository.save(consultation);
	}
	
	@PutMapping(value="/editconsultation")
	public Consultation edit(@RequestBody Consultation consultation) {
		return consultationRepository.save(consultation);
	}
	
	@DeleteMapping(value="/deleteconsultation/{id}")
	public void delete(@PathVariable Long id) {
		consultationRepository.delete(consultationRepository.getOne(id));
	}

}
