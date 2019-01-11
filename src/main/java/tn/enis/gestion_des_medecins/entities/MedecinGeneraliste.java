package tn.enis.gestion_des_medecins.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Data
@DiscriminatorValue("MG")
public class MedecinGeneraliste extends Medecin implements Serializable {

	@OneToMany(mappedBy="generaliste")
	private Collection <Patient> patients;

}
