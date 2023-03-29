package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.GenreBean;

@Stateless
public class GenresDAOImplJPA implements GenresDAO {

	@PersistenceContext(unitName = "BookManagerEJB")
	private EntityManager entityManager;

	@Override
	public List<GenreBean> getGenresList() {
		// TODO Auto-generated method stub
		Query requete = entityManager.createQuery("select n from GenreBean n");
		return requete.getResultList();
	}

	@Override
	public GenreBean getGenre(Integer id) {
		// TODO Auto-generated method stub
		GenreBean note = (GenreBean) entityManager.find(GenreBean.class, id);
		return note;
	}

	@Override
	public void insertGenre(GenreBean genre) {
		// TODO Auto-generated method stub
		entityManager.persist(genre);
	}

	@Override
	public void updateGenre(GenreBean genre) {
		// TODO Auto-generated method stub
		
	}

}
