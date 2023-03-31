package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.BorrowDatesDAO;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowDateBean;

@Stateless
public class BorrowDatesBusinessImpl implements BorrowDatesBusinessLocal, BorrowDatesBusinessRemote {

	@Inject
	private BorrowDatesDAO dao;
	
	@Override
	public boolean isBookAvailable(BookBean book) {
		return dao.isBookAvailable(book);
	}

	@Override
	public List<BorrowDateBean> getBorrowDatesList() {
		return dao.getBorrowDatesList();
	}

	@Override
	public List<BorrowDateBean> getBorrowDatesForBook(int bookId) {
		return dao.getBorrowDatesForBook(bookId);
	}
	
	@Override
	public List<BookBean> getBooksAvailable(){
		return dao.getBooksAvailable();
	}
}
