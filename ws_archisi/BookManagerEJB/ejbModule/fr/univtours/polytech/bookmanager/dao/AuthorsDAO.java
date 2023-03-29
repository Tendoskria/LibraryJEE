package fr.univtours.polytech.bookmanager.dao;

import java.util.List;

import fr.univtours.polytech.bookmanager.model.AuthorBean;

public interface AuthorsDAO {

	public List<AuthorBean> getAuthorsList();

	public AuthorBean getAuthor(Integer id);

	public void insertAuthor(AuthorBean author);

	public void updateAuthor(AuthorBean author);
}
