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
@Table(name = "GENRE")
public class GenreBean implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idGenre;
	private String genreName;
	
	@OneToMany( targetEntity=BookBean.class, mappedBy="genre")
	private List<BookBean> books = new ArrayList<>();
	
	public Integer getIdGenre() {
		return idGenre;
	}
	public String getGenreName() {
		return genreName;
	}
	public List<BookBean> getBooks() {
		return books;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}
}
