package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.AppUsersDAO;
import fr.univtours.polytech.bookmanager.model.AppUserBean;

@Stateless
public class AppUsersBusinessImpl implements AppUsersBusinessLocal, AppUsersBusinessRemote {

	@Inject
	private AppUsersDAO dao;

	@Override
	public List<AppUserBean> getAppUsersList() {
		return dao.getAppUsersList();
	}

	@Override
	public AppUserBean getAppUser(Integer id) {
		return dao.getAppUser(id);
	}

	@Override
	public void insertAppUser(AppUserBean appUser) {
		dao.insertAppUser(appUser);		
	}

	@Override
	public void updateAppUser(AppUserBean appUser) {
		dao.updateAppUser(appUser);
	}

	@Override
	public AppUserBean getAppUserIfExist(String login, String password) {
		return dao.getAppUserIfExist(login, password);
	}
}
