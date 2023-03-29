package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "APPUSER")
public class AppUserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idUser;
	private String lastNameUser;
	private String firstNameUser;
	private boolean privilege;
	
	public Integer getidUser() {
		return idUser;
	}
	public String getlastNameUser() {
		return lastNameUser;
	}
	public String getfirstNameUser() {
		return firstNameUser;
	}
	public boolean getPrivilege() {
		return privilege;
	}
	public void setidUser(Integer idUser) {
		this.idUser = idUser;
	}
	public void setlastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}
	public void setfirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}
	public void setPrivilege(boolean privilege) {
		this.privilege = privilege;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
