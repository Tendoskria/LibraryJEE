package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookBean implements Serializable {


	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idBook;
	private String bookTitle;
	
    @ManyToOne @JoinColumn(name="idAuthor", nullable=false)
	private AuthorBean author;
	

    @ManyToOne @JoinColumn(name="idGenre", nullable=false)
	private GenreBean genre;
	
    @OneToMany(mappedBy = "book")
    private List<BorrowDateBean> borrowDates = new ArrayList<>();

    public boolean isAvailable() {
        for (BorrowDateBean borrowDate : borrowDates) {
            if (borrowDate.getEndingDate().after(new Date())) {
                return false;
            }
        }
        return true;
    }

	public Integer getIdBook() {
		return idBook;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public AuthorBean getAuthor() {
		return author;
	}
	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public void setAuthor(AuthorBean author) {
		this.author = author;
	}
	public GenreBean getGenre() {
		return genre;
	}
	public void setGenre(GenreBean genre) {
		this.genre = genre;
	}
	
	
	
}
