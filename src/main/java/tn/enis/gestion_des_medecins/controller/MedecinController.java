package tn.enis.gestion_des_medecins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.enis.gestion_des_medecins.entities.Medecin;
import tn.enis.gestion_des_medecins.entities.MedecinGeneraliste;
import tn.enis.gestion_des_medecins.repositories.MedecinRepository;

import java.util.List;

@RestController
@Secured({ "ROLE_ADMIN"})
public class MedecinController {

	@Autowired
	private MedecinRepository medecinRepository;

	@RequestMapping(value = "/medecins", method = RequestMethod.GET)
	public List<Medecin> findMedecins() {
		return medecinRepository.findAll();
	}
	
	@RequestMapping(value="/medecin/{id}", method=RequestMethod.GET)
	public Medecin findOneMedecin(@PathVariable Long id) {
		return medecinRepository.findById(id).get();
	}
	
	@PostMapping(value="/savemedecin")
	public Medecin saveMedecin(@RequestBody MedecinGeneraliste medecin) {
		return medecinRepository.save(medecin);
	}

}
