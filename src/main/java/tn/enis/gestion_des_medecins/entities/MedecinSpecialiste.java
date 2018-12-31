package tn.enis.gestion_des_medecins.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
@Data
@DiscriminatorValue("MS")
public class MedecinSpecialiste extends Medecin implements Serializable {

	private String specialite;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Patient> patients;


}
