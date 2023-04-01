package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;

public interface BorrowsBusinessRemote {
	public List<BorrowBean> getBorrowsList();

	public List<BorrowBean> getBorrowsForBook(int bookId);

	public List<BorrowBean> getBorrowsOfUser(AppUserBean user);
	
	public List<BorrowBean> getCurrentBorrowsOfUser(AppUserBean user);
		
	public List<BookBean> getBooksAvailable(List<BookBean> books);
	
	public List<BorrowBean> getCurrentDelayedBorrowsOfUser(AppUserBean user);
	
	public void insertBorrow(BorrowBean borrow);
}
