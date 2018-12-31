package tn.enis.gestion_des_medecins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.gestion_des_medecins.entities.Consultation;


public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
