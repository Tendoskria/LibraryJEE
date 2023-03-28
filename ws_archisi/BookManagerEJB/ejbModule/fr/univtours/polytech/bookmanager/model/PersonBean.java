package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "PERSON" )
public class PersonBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer IdPerson;
	private String PersonLastName;
	private String PersonFirstName;
	
	public Integer getIdPerson() {
		return IdPerson;
	}
	public void setIdPerson(Integer idPerson) {
		IdPerson = idPerson;
	}
	public String getPersonLastName() {
		return PersonLastName;
	}
	public void setPersonLastName(String personLastName) {
		PersonLastName = personLastName;
	}
	public String getPersonFirstName() {
		return PersonFirstName;
	}
	public void setPersonFirstName(String personFirstName) {
		PersonFirstName = personFirstName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
