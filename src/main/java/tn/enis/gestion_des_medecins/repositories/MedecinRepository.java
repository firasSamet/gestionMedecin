package tn.enis.gestion_des_medecins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.gestion_des_medecins.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

	@Query("select m from Medecin m where m.nom like :nom")
	public List<Medecin> chercher(@Param("nom") String nom);

}
