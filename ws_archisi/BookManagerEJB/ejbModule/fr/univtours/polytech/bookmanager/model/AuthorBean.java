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
@Table(name= "AUTHOR")
public class AuthorBean  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idAuthor;
	private String firstNameAuthor;
	private String lastNameAuthor;
	
    @OneToMany( targetEntity=BookBean.class, mappedBy="author" )
	private List<BookBean> books = new ArrayList<>();
	
	public Integer getidAuthor() {
		return idAuthor;
	}
	public String getfirstNameAuthor() {
		return firstNameAuthor;
	}
	public String getlastNameAuthor() {
		return lastNameAuthor;
	}
	public List<BookBean> getBooks() {
		return books;
	}
	public void setidAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}
	public void setfirstNameAuthor(String firstNameAuthor) {
		this.firstNameAuthor = firstNameAuthor;
	}
	public void setlastNameAuthor(String lastNameAuthor) {
		this.lastNameAuthor = lastNameAuthor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
