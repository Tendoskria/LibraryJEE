package fr.univtours.polytech.bookmanager.business;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.AppUsersDAO;
import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowDateBean;

@Stateless
public class BorrowDatesBusinessImpl implements AppUsersBusinessLocal, AppUsersBusinessRemote {

	@Inject
	private AppUsersDAO dao;
	
}
