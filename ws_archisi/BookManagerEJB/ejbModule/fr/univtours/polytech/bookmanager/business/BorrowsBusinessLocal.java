package fr.univtours.polytech.bookmanager.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;

@Local
public interface BorrowsBusinessLocal {

	public List<BorrowBean> getBorrowsList();

	public BorrowBean getCurrentBorrowOfBook(BookBean book);
	
	public List<BorrowBean> getBorrowsForBook(int bookId);

	public List<BorrowBean> getBorrowsOfUser(AppUserBean user);

	public List<BorrowBean> getCurrentBorrowsOfUser(AppUserBean user);
		
	public List<BookBean> getBooksAvailable(List<BookBean> books);
	
	public List<BorrowBean> getCurrentDelayedBorrowsOfUser(AppUserBean user);
	
	public void insertBorrow(BorrowBean borrow);
	
	public void updateBorrow(BorrowBean borrow);
}
