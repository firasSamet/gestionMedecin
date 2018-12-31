package tn.enis.gestion_des_medecins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.gestion_des_medecins.entities.Medecin;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

	@Query("select m from Medecin m where m.nom like :nom")
	List<Medecin> findByName(@Param("nom") String nom);

}
