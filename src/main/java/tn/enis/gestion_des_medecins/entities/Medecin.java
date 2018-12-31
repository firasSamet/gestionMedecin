package tn.enis.gestion_des_medecins.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_med",discriminatorType=DiscriminatorType.STRING, length=2)
public class Medecin implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	private String email;
	@Lob
	private byte[] photo;
	private String codePublic;
	
	@OneToMany(mappedBy="medecin")
	private Collection<Consultation> consultations;

}
