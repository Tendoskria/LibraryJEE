package fr.univtours.polytech.bookmanager.business;

import java.util.List;

import javax.ejb.Remote;

import fr.univtours.polytech.bookmanager.model.AuthorBean;

@Remote
public interface AuthorsBusinessRemote {
	public List<AuthorBean> getAuthorsList();

	public AuthorBean getAuthor(Integer id);

	public void insertAuthor(AuthorBean author);

	public void updateAuthor(AuthorBean author);
}
