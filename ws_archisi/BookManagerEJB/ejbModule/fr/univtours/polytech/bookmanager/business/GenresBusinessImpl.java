package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.univtours.polytech.bookmanager.dao.GenresDAO;
import fr.univtours.polytech.bookmanager.model.GenreBean;

@Stateless
public class GenresBusinessImpl implements GenresBusinessLocal, GenresBusinessRemote {

	@Inject
	private GenresDAO dao;

	@Override
	public List<GenreBean> getGenresList() {
		// TODO Auto-generated method stub
		return this.dao.getGenresList();
	}

	@Override
	public GenreBean getGenre(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.getGenre(id);
	}

	@Override
	public void insertGenre(GenreBean genre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGenre(GenreBean genre) {
		// TODO Auto-generated method stub
		
	}
}
