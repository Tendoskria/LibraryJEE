package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.AppUserBean;

public interface AppUsersDAO {

	public List<AppUserBean> getAppUsersList();

	public AppUserBean getAppUser(Integer id);

	public void insertNote(AppUserBean appUser);

	public void updateNote(AppUserBean appUser);
}
