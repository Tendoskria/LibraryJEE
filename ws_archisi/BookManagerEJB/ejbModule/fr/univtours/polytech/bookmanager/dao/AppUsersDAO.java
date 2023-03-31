package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.AppUserBean;

public interface AppUsersDAO {

	public List<AppUserBean> getAppUsersList();

	public AppUserBean getAppUser(Integer id);

	public void insertAppUser(AppUserBean appUser);

	public void updateAppUser(AppUserBean appUser);
	
	public AppUserBean getAppUserIfExist(String login, String password);
}
