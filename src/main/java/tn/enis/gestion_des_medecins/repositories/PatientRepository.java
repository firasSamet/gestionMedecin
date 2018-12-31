package tn.enis.gestion_des_medecins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.gestion_des_medecins.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select p from Patient p where p.nom like :nom")
    public List<Patient> chercher(@Param("nom") String nom);
}
