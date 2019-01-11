package tn.enis.gestion_des_medecins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.enis.gestion_des_medecins.repositories.MedecinRepository;
import tn.enis.gestion_des_medecins.entities.Medecin;
import tn.enis.gestion_des_medecins.entities.MedecinGeneraliste;

@RestController
public class MedecinController {

	@Autowired
	private MedecinRepository medecinRepository;

	@RequestMapping(value = "/medecins", method = RequestMethod.GET)
	public List<Medecin> findMedecins() {
		return medecinRepository.findAll();
	}
	
	@RequestMapping(value="/medecin/{id}", method=RequestMethod.GET)
	public Medecin findOneMedecin(@PathVariable Long id) {
		return (Medecin) medecinRepository.findById(id).get();
	}
	
	@PostMapping(value="/savemedecin")
	public Medecin saveMedecin(@RequestBody MedecinGeneraliste medecin) {
		return (Medecin) medecinRepository.save(medecin);
	}

}
