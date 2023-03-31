package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowDateBean;

public interface BorrowDatesBusinessRemote {
	public List<BorrowDateBean> getBorrowDatesList();

	public List<BorrowDateBean> getBorrowDatesForBook(int bookId);

	public boolean isBookAvailable(BookBean book);
	
	public List<BookBean> getBooksAvailable();
}
