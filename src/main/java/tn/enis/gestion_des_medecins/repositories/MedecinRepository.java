package tn.enis.gestion_des_medecins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.gestion_des_medecins.entities.Medecin;

public interface MedecinRepository< T extends Medecin> extends JpaRepository<T, Long> {

	@Query("select m from Medecin m where m.nom like :nom")
	public List<T> chercher(@Param("nom") String nom);
	T findByEmail(String email);
	boolean existsByEmail(String email);
}
