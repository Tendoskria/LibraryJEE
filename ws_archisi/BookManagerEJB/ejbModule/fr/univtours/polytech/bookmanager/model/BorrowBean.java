package fr.univtours.polytech.bookmanager.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(BorrowId.class)
@Table(name = "Borrow")
public class BorrowBean {
	@Id
	private Date startingDate;
	@Id
	private Date endingDate;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idBook")
	private BookBean book;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private AppUserBean user;

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public AppUserBean getUser() {
		return user;
	}

	public void setUser(AppUserBean user) {
		this.user = user;
	}
}
