package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.univtours.polytech.bookmanager.model.BookBean;

@Stateless
public class BooksDAOImplJPA implements BooksDAO {

	@PersistenceContext(unitName = "BookManagerEJB")
	private EntityManager entityManager;
	

	@Override
	public List<BookBean> getBooksList() {
		// TODO Auto-generated method stub
		Query requete = entityManager.createQuery("select n from BookBean n");
		return requete.getResultList();
	}

	@Override
	public BookBean getBook(Integer id) {
		// TODO Auto-generated method stub
		BookBean note = (BookBean) entityManager.find(BookBean.class, id);
		return note;
	}

	@Override
	public void insertBook(BookBean book) {
		// TODO Auto-generated method stub
		entityManager.persist(book);
	}

	@Override
	public void updateBook(BookBean book) {
		// TODO Auto-generated method stub
		
	}

	
}
