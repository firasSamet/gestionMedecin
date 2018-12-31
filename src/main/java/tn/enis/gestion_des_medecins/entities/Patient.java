package tn.enis.gestion_des_medecins.entities;

import lombok.Data;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

@Entity
@Data
public class Patient implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Lob
	private byte[] photo;
	private String email;
	private String tel;
	private String numCnam;

	@ManyToOne(cascade = CascadeType.ALL)
	private MedecinGeneraliste generaliste;

	@ManyToMany(mappedBy = "patients", fetch = FetchType.LAZY)
	private Collection<MedecinSpecialiste> specialistes;

	@OneToMany(mappedBy = "patient")
	private Collection<Consultation> consultations;


}
