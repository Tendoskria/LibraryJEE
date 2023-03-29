package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
public class GenreBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer IdGenre;
	private String GenreName;
	
	public Integer getIdGenre() {
		return IdGenre;
	}
	public void setIdGenre(Integer idGenre) {
		IdGenre = idGenre;
	}
	public String getGenreName() {
		return GenreName;
	}
	public void setGenreName(String genreName) {
		GenreName = genreName;
	}
	
	
	
	
	
	
	
}
