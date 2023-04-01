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
		Query query = entityManager.createQuery("select n from BookBean n");
		return query.getResultList();
	}

	@Override
	public BookBean getBook(Integer id) {
		BookBean book = (BookBean) entityManager.find(BookBean.class, id);
		return book;
	}

	@Override
	public void insertBook(BookBean book) {
		entityManager.persist(book);
	}

	@Override
	public void updateBook(BookBean book) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<BookBean> getFilteredBook(String titleFilter, String authorFilter, String genreFilter){
		String sql = "SELECT b FROM BookBean b, AuthorBean a, GenreBean g "
				+ "WHERE b.author.idAuthor = a.idAuthor AND b.genre.idGenre = g.idGenre AND "
				+ "b.bookTitle LIKE ?1 AND (a.firstNameAuthor LIKE ?2 OR a.lastNameAuthor LIKE ?2) AND g.genreName LIKE ?3";
		
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, "%" + titleFilter +"%");
		query.setParameter(2, "%" + authorFilter +"%");
		query.setParameter(3, "%" + genreFilter +"%");
		return query.getResultList();
	}
	
	
}
