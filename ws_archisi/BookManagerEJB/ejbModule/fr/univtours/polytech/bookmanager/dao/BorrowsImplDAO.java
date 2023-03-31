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
import fr.univtours.polytech.bookmanager.model.BorrowBean;

@Stateless
public class BorrowsImplDAO implements BorrowsDAO {

	@PersistenceContext(unitName = "BookManagerEJB")
	private EntityManager entityManager;

	@Override
	public List<BorrowBean> getBorrowsList() {
		Query query = entityManager.createQuery("select n from BorrowBean n");
		return query.getResultList();
	}

	@Override
	public List<BorrowBean> getBorrowsForBook(int bookId) {
		Query query = entityManager.createQuery("SELECT b FROM BorrowBean b WHERE b.book.idBook = ?1");
		query.setParameter(1, bookId);
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
		Boolean flag = false;		
		if (book != null) {
			Date currentDate = new Date();
			List<BorrowBean> borrows = getBorrowsForBook(book.getIdBook());
			for (BorrowBean borrow : borrows) {
				System.out.println(borrow.getBook().getIdBook());
				System.out.println(borrow.getStartingDate());
				System.out.println(currentDate);
				if (borrow.getStartingDate().before(currentDate) && borrow.getEndingDate().after(currentDate)) {
					flag = false;
				}
				else {
					flag = true;
				}
			}
		}
		return flag;
	}

	public List<BookBean> getBooksAvailable() {
		List<BookBean> booksAvailable = new ArrayList<BookBean>();
		List<BorrowBean> borrowBeans = getBorrowsList();
		for (BorrowBean borrowBean : borrowBeans) {
			if (isBookAvailable(borrowBean.getBook())) {
				booksAvailable.add(borrowBean.getBook());
			}
		}
		return booksAvailable;
	}
}
