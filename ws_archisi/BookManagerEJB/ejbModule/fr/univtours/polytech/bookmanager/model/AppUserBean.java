package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "USER")
public class AppUserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer IdUser;
	private String LastNameUser;
	private String FirstNameUser;
	private boolean privilege;
	
	public Integer getIdUser() {
		return IdUser;
	}
	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}
	public String getLastNameUser() {
		return LastNameUser;
	}
	public void setLastNameUser(String lastNameUser) {
		LastNameUser = lastNameUser;
	}
	public String getFirstNameUser() {
		return FirstNameUser;
	}
	public void setFirstNameUser(String firstNameUser) {
		FirstNameUser = firstNameUser;
	}
	public boolean isPrivilege() {
		return privilege;
	}
	public void setPrivilege(boolean privilege) {
		this.privilege = privilege;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
