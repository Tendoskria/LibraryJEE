package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.AuthorsDAO;
import fr.univtours.polytech.bookmanager.model.AuthorBean;

@Stateless
public class AuthorsBusinessImpl implements AuthorsBusinessLocal, AuthorsBusinessRemote{

	@Inject
	private AuthorsDAO dao;

	@Override
	public List<AuthorBean> getAuthorsList() {
		return dao.getAuthorsList();
	}

	@Override
	public AuthorBean getAuthor(Integer id) {
		return dao.getAuthor(id);
	}

	@Override
	public void insertAuthor(AuthorBean author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuthor(AuthorBean author) {
		// TODO Auto-generated method stub
		
	}
}
