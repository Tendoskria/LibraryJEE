package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Local;

import fr.univtours.polytech.bookmanager.model.GenreBean;
@Local
public interface GenresBusinessLocal {

	public List<GenreBean> getGenresList();

	public GenreBean getGenre(Integer id);

	public void insertGenre(GenreBean genre);

	public void updateGenre(GenreBean genre);
}
