package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(MyKey.class)
@Table(name = "BorrowDate")
public class BorrowDateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name = "STARTING_DATE")
	    private Date startingDate;

	    @Id
	    @Column(name = "ENDING_DATE")
	    private Date endingDate;

	    @ManyToOne
	    @JoinColumn(name = "USER_ID")
	    private AppUserBean user;

	    @ManyToOne
	    @JoinColumn(name = "BOOK_ID")
	    private BookBean book;

		public Date getStartingDate() {
			return startingDate;
		}

		public void setStartingDate(java.util.Date date) {
			this.startingDate = (Date) date;
		}

		public Date getEndingDate() {
			return endingDate;
		}

		public void setEndingDate(Date endingDate) {
			this.endingDate = endingDate;
		}

		public AppUserBean getUser() {
			return user;
		}

		public void setUser(AppUserBean user) {
			this.user = user;
		}

		public BookBean getBook() {
			return book;
		}

		public void setBook(BookBean book) {
			this.book = book;
		}
	    
	    
	
	

}
