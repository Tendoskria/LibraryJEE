package fr.univtours.polytech.bookmanager.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.BorrowsDAO;
import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;

@Stateless
public class BorrowsBusinessImpl implements BorrowsBusinessLocal, BorrowsBusinessRemote {

	@Inject
	private BorrowsDAO dao;

	@Override
	public List<BorrowBean> getBorrowsList() {
		return dao.getBorrowsList();
	}

	@Override
	public BorrowBean getCurrentBorrowOfBook(BookBean book) {
		return dao.getCurrentBorrowOfBook(book);
	}
	
	@Override
	public List<BorrowBean> getBorrowsForBook(int bookId) {
		return dao.getBorrowsForBook(bookId);
	}
	
	@Override
	public List<BorrowBean> getBorrowsOfUser(AppUserBean user) {
		return dao.getBorrowsOfUser(user);
	}
	
	@Override	
	public List<BorrowBean> getCurrentBorrowsOfUser(AppUserBean user){
		return dao.getCurrentBorrowsOfUser(user);
	}
	
	@Override
	public List<BookBean> getBooksAvailable(List<BookBean> books){
		return dao.getBooksAvailable(books);
	}
	
	@Override
	public List<BorrowBean> getCurrentDelayedBorrowsOfUser(AppUserBean user){
		return dao.getCurrentDelayedBorrowsOfUser(user);
	}
	
	@Override
	public void insertBorrow(BorrowBean borrow) {
		dao.insertBorrow(borrow);
	}
	
	@Override
	public void updateBorrow(BorrowBean borrow) {
		dao.updateBorrow(borrow);
	}
}
