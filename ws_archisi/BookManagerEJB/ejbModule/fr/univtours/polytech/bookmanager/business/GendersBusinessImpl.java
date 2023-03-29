package fr.univtours.polytech.bookmanager.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.GenresDAO;

@Stateless
public class GendersBusinessImpl implements GendersBusinessLocal, GendersBusinessRemote {

	@Inject
	private GenresDAO dao;
}
