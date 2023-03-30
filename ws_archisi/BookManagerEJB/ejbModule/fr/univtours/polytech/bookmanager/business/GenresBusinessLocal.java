package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.GenreBean;

public interface GenresBusinessLocal {

	public List<GenreBean> getGenresList();

	public GenreBean getGenre(Integer id);

	public void insertGenre(GenreBean genre);

	public void updateGenre(GenreBean genre);
}
