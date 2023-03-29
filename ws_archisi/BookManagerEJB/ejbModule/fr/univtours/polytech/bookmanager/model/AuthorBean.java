package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "AUTHOR")
public class AuthorBean  implements Serializable  {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer IdAuthor;
	private String FirstNameAuthor;
	private String LastNameAuthor;
	
	public Integer getIdAuthor() {
		return IdAuthor;
	}
	public void setIdAuthor(Integer idAuthor) {
		IdAuthor = idAuthor;
	}
	public String getFirstNameAuthor() {
		return FirstNameAuthor;
	}
	public void setFirstNameAuthor(String firstNameAuthor) {
		FirstNameAuthor = firstNameAuthor;
	}
	public String getLastNameAuthor() {
		return LastNameAuthor;
	}
	public void setLastNameAuthor(String lastNameAuthor) {
		LastNameAuthor = lastNameAuthor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
