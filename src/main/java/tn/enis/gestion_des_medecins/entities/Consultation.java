package tn.enis.gestion_des_medecins.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
public class Consultation implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private  String notes;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Medecin medecin;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Patient patient;

}
