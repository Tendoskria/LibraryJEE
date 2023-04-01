package fr.univtours.polytech.bookmanager.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;
import fr.univtours.polytech.bookmanager.model.BorrowId;

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
	public BorrowBean getCurrentBorrowOfBook(BookBean book) {
		List<BorrowBean> borrows = getBorrowsForBook(book.getIdBook());
		for (BorrowBean borrow : borrows) {
			if (!isBorrowEnd(borrow)) {
				return borrow;
			}
		}
		return null;
	}
	
	@Override
	public List<BorrowBean> getBorrowsForBook(int bookId) {
		Query query = entityManager.createQuery("SELECT b FROM BorrowBean b WHERE b.book.idBook = ?1");
		query.setParameter(1, bookId);
		return query.getResultList();
	}

	@Override
	public List<BorrowBean> getBorrowsOfUser(AppUserBean user) {
		Query query = entityManager.createQuery("SELECT b FROM BorrowBean b WHERE b.user.idUser = ?1");
		query.setParameter(1, user.getIdUser());
		return query.getResultList();
	}
	
	@Override
	public List<BorrowBean> getCurrentBorrowsOfUser(AppUserBean user) {
		List<BorrowBean> currentBorrows = new ArrayList<>();
		List<BorrowBean> borrowBeans = getBorrowsOfUser(user);
		for (BorrowBean borrow : borrowBeans) {
			if(!isBorrowEnd(borrow)) {
				currentBorrows.add(borrow);
			}
		}
		return currentBorrows;
	}
	
	public boolean isBorrowEnd(BorrowBean borrow) {
		Boolean flag = false;
		if (borrow.getIsBorrowEnd()) {
			flag = true;
		}
		else {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBookAvailable(BookBean book) {
		Boolean flag = false;		
		if (book != null) {
			List<BorrowBean> borrows = getBorrowsForBook(book.getIdBook());
			if(borrows.size() == 0) {
				flag = true;
			}
			for (BorrowBean borrow : borrows) {
				flag = isBorrowEnd(borrow);
			}
		}
		return flag;
	}
	
	@Override
	public List<BookBean> getBooksAvailable(List<BookBean> books) {
		List<BookBean> booksAvailable = new ArrayList<BookBean>();
		for (BookBean book : books) {
			if (isBookAvailable(book)) {
				booksAvailable.add(book);
			}
		}
		return booksAvailable;
	}
	
	public Boolean isBorrowHadDelay(BorrowBean borrow) {
		Boolean flag = false;
		Date currentDate = new Date();
		if (!borrow.getIsBorrowEnd() && borrow.getEndingDate().before(currentDate)) {
			flag = true;
		}
		else {
			flag = false;
		}
		return flag;
	}
	
	@Override
	public List<BorrowBean> getCurrentDelayedBorrowsOfUser(AppUserBean user){
		List<BorrowBean> delayedBorrows = new ArrayList<>();
		List<BorrowBean> borrowBeans = getCurrentBorrowsOfUser(user);
		for (BorrowBean borrow : borrowBeans) {
			if(isBorrowHadDelay(borrow)) {
				delayedBorrows.add(borrow);
			}
		}
		return delayedBorrows;
	}
	
	@Override
	public void insertBorrow(BorrowBean borrow) {
		entityManager.merge(borrow);
	}

	@Override
	public void updateBorrow(BorrowBean borrow) {
		String hqlUpdate = "UPDATE BorrowBean b SET b.isBorrowEnd = ?1 "
				+ "WHERE b.book.idBook = ?2 AND b.startingDate = ?3 AND b.endingDate = ?4";
		Query query = entityManager.createQuery(hqlUpdate);
		query.setParameter(1, true);
		query.setParameter(2, borrow.getBook().getIdBook());
		query.setParameter(3, borrow.getStartingDate());
		query.setParameter(4, borrow.getEndingDate());
		query.executeUpdate();
	}
	

}
