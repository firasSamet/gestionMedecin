package tn.enis.gestion_des_medecins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.enis.gestion_des_medecins.entities.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("select p from Patient p where p.nom like :nom")
    List<Patient> findByName(@Param("nom") String nom);
}
