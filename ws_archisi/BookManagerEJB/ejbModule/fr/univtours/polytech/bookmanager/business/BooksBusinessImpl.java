package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.BooksDAO;
import fr.univtours.polytech.bookmanager.model.BookBean;

@Stateless
public class BooksBusinessImpl implements BooksBusinessLocal, BooksBusinessRemote {

	@Inject
	private BooksDAO dao;

	
	@Override
	public List<BookBean> getBooksList() {
		return dao.getBooksList();
	}

	@Override
	public BookBean getBean(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBook(BookBean book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(BookBean book) {
		// TODO Auto-generated method stub
		
	}
	
	
}
