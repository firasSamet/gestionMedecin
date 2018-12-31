package tn.enis.gestion_des_medecins.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
