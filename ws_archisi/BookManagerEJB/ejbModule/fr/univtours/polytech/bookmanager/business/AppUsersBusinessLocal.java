package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Local;

import fr.univtours.polytech.bookmanager.model.AppUserBean;

@Local
public interface AppUsersBusinessLocal {

	public List<AppUserBean> getAppUsersList();

	public AppUserBean getAppUser(Integer id);

	public void insertAppUser(AppUserBean appUser);

	public void updateAppUser(AppUserBean appUser);
	
	public AppUserBean getAppUserIfExist(String login, String password);
	
	public AppUserBean getAppUser(String login);
}
