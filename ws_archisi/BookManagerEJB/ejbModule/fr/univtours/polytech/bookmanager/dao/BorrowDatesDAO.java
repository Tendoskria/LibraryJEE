package fr.univtours.polytech.bookmanager.dao;

import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;

public interface BorrowDatesDAO {

	public void borrowBook(AppUserBean user, BookBean book);
}
