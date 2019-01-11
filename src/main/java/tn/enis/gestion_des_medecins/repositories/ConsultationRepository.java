package tn.enis.gestion_des_medecins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.enis.gestion_des_medecins.entities.Consultation;
import tn.enis.gestion_des_medecins.entities.Medecin;
import tn.enis.gestion_des_medecins.entities.Patient;

import java.util.List;


public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query("select c from Consultation c where c.patient like :patient")
    List<Consultation> listConsultsOfPatient(Patient patient);

    @Query("select c from Consultation c where c.medecin like :medecin")
    List<Consultation> listConsultsOfDoctor(Medecin medecin);
}
