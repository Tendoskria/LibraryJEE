package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.BookBean;

public class BooksDAOImplJPA implements BooksDAO {

	@PersistenceContext(unitName = "GestionNotesEJB")
	private EntityManager entityManager;
	

	@Override
	public List<BookBean> getBooksList() {
		// TODO Auto-generated method stub
		Query requete = entityManager.createQuery("select n from BookBean n");
		return requete.getResultList();
	}

	@Override
	public BookBean getNote(Integer id) {
		// TODO Auto-generated method stub
		BookBean note = (BookBean) entityManager.find(BookBean.class, id);
		return note;
	}

	@Override
	public void insertNote(BookBean note) {
		// TODO Auto-generated method stub
		entityManager.persist(note);
	}

	@Override
	public void updateNote(BookBean note) {
		// TODO Auto-generated method stub
		
	}

	
}
