package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowDateBean;

public interface BorrowDatesDAO {
	public List<BorrowDateBean> getBorrowDatesList();
	
	public List<BorrowDateBean> getBorrowDatesForBook(int bookId);
	
	public List<BookBean> getBooksAvailable();
	
	public boolean isBookAvailable(BookBean book);
}
