package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;

public interface BorrowsBusinessRemote {
	public List<BorrowBean> getBorrowsList();

	public List<BorrowBean> getBorrowsForBook(int bookId);

	public boolean isBookAvailable(BookBean book);
	
	public List<BookBean> getBooksAvailable();
}
