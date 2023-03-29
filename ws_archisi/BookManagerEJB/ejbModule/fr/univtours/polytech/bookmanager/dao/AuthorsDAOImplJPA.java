package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.AuthorBean;

@Stateless
public class AuthorsDAOImplJPA  implements AuthorsDAO{

	@PersistenceContext(unitName = "BookManagerEJB")
	private EntityManager entityManager;

	@Override
	public List<AuthorBean> getAuthorsList() {
		// TODO Auto-generated method stub
		Query requete = entityManager.createQuery("select n from AuthorBean n");
		return requete.getResultList();
	}

	@Override
	public AuthorBean getAuthor(Integer id) {
		// TODO Auto-generated method stub
		AuthorBean authorBean = (AuthorBean) entityManager.find(AuthorBean.class, id);
		return authorBean;
	}

	@Override
	public void insertAuthor(AuthorBean author) {
		// TODO Auto-generated method stub
		entityManager.persist(author);
	}

	@Override
	public void updateAuthor(AuthorBean Author) {
		// TODO Auto-generated method stub
		
	}

}
