package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Remote;

import fr.univtours.polytech.bookmanager.model.BookBean;

@Remote
public interface BooksBusinessRemote {
	public List<BookBean> getBooksList();

    public BookBean getBean(Integer id);

    public void insertBook(BookBean book);

    public void updateBook(BookBean book);
}
