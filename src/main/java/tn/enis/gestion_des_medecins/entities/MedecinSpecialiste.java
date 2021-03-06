package tn.enis.gestion_des_medecins.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@DiscriminatorValue("MS")
public class MedecinSpecialiste extends Medecin implements Serializable {

	private String specialite;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Patient> patients;


}
