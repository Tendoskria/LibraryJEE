package fr.univtours.polytech.bookmanager.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.AppUsersDAO;

@Stateless
public class AppUsersBusinessImpl implements AppUsersBusinessLocal, AppUsersBusinessRemote {

	@Inject
	private AppUsersDAO dao;
}
