package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.BookBean;

public interface BooksDAO {

	public List<BookBean> getBooksList();

	public BookBean getBook(Integer id);

	public void insertBook(BookBean book);

	public void updateBook(BookBean book);
}
