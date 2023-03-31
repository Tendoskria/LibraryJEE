package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Remote;

import fr.univtours.polytech.bookmanager.model.AppUserBean;

@Remote
public interface AppUsersBusinessRemote {
	public List<AppUserBean> getAppUsersList();

	public AppUserBean getAppUser(Integer id);

	public void insertAppUser(AppUserBean appUser);

	public void updateAppUser(AppUserBean appUser);
	
	public AppUserBean getAppUserIfExist(String login, String password);
}
