package fr.univtours.polytech.bookmanager.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowDateBean;

@Stateless
public class BorrowDatesImplDAO implements BorrowDatesDAO{

	@PersistenceContext(unitName = "BookManagerEJB")
	private EntityManager entityManager;
	
	@Override
	public List<BorrowDateBean> getBorrowDatesList() {
		Query query = entityManager.createQuery("select n from BorrowDateBean n");
		return query.getResultList();
	}
	
	@Override
	public List<BorrowDateBean> getBorrowDatesForBook(int bookId) {
		 Query  query = entityManager.createQuery("SELECT b FROM BorrowDateBean b WHERE b.idbook = :bookId");
	    query.setParameter("bookId", bookId);
	    return query.getResultList();
	}
	
	public Date addDays(Date date, int days) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, days);
	    return calendar.getTime();
	}
	
	@Override
	public boolean isBookAvailable(BookBean book) {
		Date currentDate = new Date();
		List<BorrowDateBean> borrowDates = getBorrowDatesForBook(book.getIdBook());
	    Boolean flag = true;
	    for (BorrowDateBean borrowDate : borrowDates) {
	    	 if (borrowDate.getStartingDate().after(addDays(currentDate, -10))) {
	            // the book has been reserved in the last 10 days
	           flag = false;
	        }
	    }	
	    return flag;
	}	
	
	public List<BookBean> getBooksAvailable() {
		List<BookBean> booksAvailable = new ArrayList<BookBean>();
		List<BorrowDateBean> borrowDateBeans = getBorrowDatesList();
		for (BorrowDateBean borrowDateBean : borrowDateBeans) {
			if (isBookAvailable(borrowDateBean.getBook())) {
				booksAvailable.add(borrowDateBean.getBook());
			}
		}
		return booksAvailable;
	}

}
