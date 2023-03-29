package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.BookBean;

public interface BooksDAO {

	public List<BookBean> getBooksList();

	public BookBean getNote(Integer id);

	public void insertNote(BookBean note);

	public void updateNote(BookBean note);
}
