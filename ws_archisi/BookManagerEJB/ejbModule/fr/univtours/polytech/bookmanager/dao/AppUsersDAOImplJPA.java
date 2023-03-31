package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.AppUserBean;

@Stateless
public class AppUsersDAOImplJPA implements AppUsersDAO{

	@PersistenceContext(unitName = "BookManagerEJB")
	private EntityManager entityManager;

	@Override
	public List<AppUserBean> getAppUsersList() {
		// TODO Auto-generated method stub
		Query requete = entityManager.createQuery("select n from AppUserBean n");
		return requete.getResultList();
	}

	@Override
	public AppUserBean getAppUser(Integer id) {
		AppUserBean appUser = (AppUserBean) entityManager.find(AppUserBean.class, id);
		return appUser;
	}

	@Override
	public AppUserBean getAppUser(String login) {
		List<AppUserBean> appUserList = getAppUsersList();
		for (AppUserBean appUser : appUserList) {
			if (appUser.getLogin().equals(login)) {
				return appUser;
			}
		}
		return null;
	}	
	
	@Override
	public void insertAppUser(AppUserBean appUser) {
		// TODO Auto-generated method stub
		entityManager.persist(appUser);
	}

	@Override
	public void updateAppUser(AppUserBean appUser) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public AppUserBean getAppUserIfExist(String login, String password) {
		List<AppUserBean> appUserList = getAppUsersList();
		for (AppUserBean appUser : appUserList) {
			if (appUser.getLogin().equals(login) && appUser.getPassword().equals(password)) {
				return appUser;
			}
		}
		return null;
	}	
}
