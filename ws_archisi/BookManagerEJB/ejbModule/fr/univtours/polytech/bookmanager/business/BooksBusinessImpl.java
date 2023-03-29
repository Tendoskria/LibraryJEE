package fr.univtours.polytech.bookmanager.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.BooksDAO;

@Stateless
public class BooksBusinessImpl implements BooksBusinessLocal, BooksBusinessRemote {

	@Inject
	private BooksDAO dao;
}
