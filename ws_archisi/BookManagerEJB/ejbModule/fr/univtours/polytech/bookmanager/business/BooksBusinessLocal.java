package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Local;

import fr.univtours.polytech.bookmanager.model.BookBean;

@Local
public interface BooksBusinessLocal {

    public List<BookBean> getBooksList();

    public BookBean getBean(Integer id);

    public void insertBook(BookBean book);

    public void updateBook(BookBean book);

}
