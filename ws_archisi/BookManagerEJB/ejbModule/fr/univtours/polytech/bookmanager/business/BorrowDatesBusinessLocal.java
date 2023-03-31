package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Local;

import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowDateBean;
import fr.univtours.polytech.bookmanager.model.GenreBean;

@Local
public interface BorrowDatesBusinessLocal {

	public List<BorrowDateBean> getBorrowDatesList();

	public List<BorrowDateBean> getBorrowDatesForBook(int bookId);

	public boolean isBookAvailable(BookBean book);
	
	public List<BookBean> getBooksAvailable();
}
