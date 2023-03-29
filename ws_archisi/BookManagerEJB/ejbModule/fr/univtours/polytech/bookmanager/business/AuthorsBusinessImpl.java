package fr.univtours.polytech.bookmanager.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.AuthorsDAO;

@Stateless
public class AuthorsBusinessImpl implements AuthorsBusinessLocal, AuthorsBusinessRemote{

	@Inject
	private AuthorsDAO dao;
}
