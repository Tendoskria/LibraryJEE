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
	public BookBean getBook(Integer id) {
		return dao.getBook(id);
	}

	@Override
	public void insertBook(BookBean book) {
		dao.insertBook(book);
	}

	@Override
	public void updateBook(BookBean book) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<BookBean> getFilteredBook(String titleFilter, String authorFilter, String genreFilter){
		return dao.getFilteredBook(titleFilter, authorFilter, genreFilter);
	}
}
