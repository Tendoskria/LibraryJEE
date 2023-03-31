package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APPUSER")
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
	private String login;
	private String password;
	
	@OneToMany(targetEntity=BorrowBean.class, mappedBy = "user")
	private List<BorrowBean> borrows = new ArrayList<>();

	public boolean canBorrow() {
		return borrows.size() < 5;
	}

	public Integer getIdUser() {
		return idUser;
	}
	public String getLastNameUser() {
		return lastNameUser;
	}
	public String getFirstNameUser() {
		return firstNameUser;
	}

	public boolean getPrivilege() {
		return privilege;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}


	
	public void setidUser(Integer idUser) {
		this.idUser = idUser;
	}

	public void setlastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}
	public void setFirstNameUser(String firstNameUser) {

		this.firstNameUser = firstNameUser;
	}

	public void setPrivilege(boolean privilege) {
		this.privilege = privilege;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
