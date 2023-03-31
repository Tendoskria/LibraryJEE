package fr.univtours.polytech.bookmanager.model;

import java.io.Serializable;
import java.sql.Date;

public class BorrowDateId implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer book;
   
    private Date endingDate;
    
    private Date startingDate;
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	return super.equals(obj);
    }
    public Integer getBook() {
		return book;
	}
	public void setBook(Integer book) {
		this.book = book;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
