package tn.enis.gestion_des_medecins.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_med",discriminatorType=DiscriminatorType.STRING, length=2)
public class Medecin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nom;
	@NotBlank

	private String prenom;
	@Transient
	@NotBlank
	private String type;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@Lob
	private byte[] photo;
	private String codePublic;

	@OneToMany(mappedBy = "medecin")
	private Collection<Consultation> consultations;


}