package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.BorrowsDAO;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;

@Stateless
public class BorrowsBusinessImpl implements BorrowsBusinessLocal, BorrowsBusinessRemote {

	@Inject
	private BorrowsDAO dao;
	
	@Override
	public boolean isBookAvailable(BookBean book) {
		return dao.isBookAvailable(book);
	}

	@Override
	public List<BorrowBean> getBorrowsList() {
		return dao.getBorrowsList();
	}

	@Override
	public List<BorrowBean> getBorrowsForBook(int bookId) {
		return dao.getBorrowsForBook(bookId);
	}
	
	@Override
	public List<BookBean> getBooksAvailable(){
		return dao.getBooksAvailable();
	}
}
