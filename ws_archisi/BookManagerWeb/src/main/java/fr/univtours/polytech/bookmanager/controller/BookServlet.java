package fr.univtours.polytech.bookmanager.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univtours.polytech.bookmanager.business.AppUsersBusinessLocal;
import fr.univtours.polytech.bookmanager.business.AuthorsBusinessLocal;
import fr.univtours.polytech.bookmanager.business.BooksBusinessLocal;
import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.business.GenresBusinessLocal;
import fr.univtours.polytech.bookmanager.model.AuthorBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.GenreBean;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(name = "BookServlet", urlPatterns = { "/book-manager" })
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BooksBusinessLocal booksBusinessLocal;

	@EJB
	private AuthorsBusinessLocal authorsBusinessLocal;
	
	@EJB
	private AppUsersBusinessLocal appUsersBusinessLocal;
	
	@EJB
	private GenresBusinessLocal genresBusinessLocal;
	
	private static String USERNAME = "USERNAME";
	private static String LOGIN_INCORRECT = "LOGIN_INCORRECT";

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the content of the filters fields.
		String titleFilter = request.getParameter("title");
		String authorFilter = request.getParameter("author");
		String genreFilter = request.getParameter("genre");
		
		// If every filters fields empty means that there is no research. Consequently, show every book in base.
		if (titleFilter == null && authorFilter == null && genreFilter == null) {
			List<BookBean> books = this.booksBusinessLocal.getBooksList();
		    request.setAttribute("BOOKS_LIST", books);
		}
		else {
			List<BookBean> books = this.booksBusinessLocal.getFilteredBook(titleFilter, authorFilter, genreFilter);
		    request.setAttribute("BOOKS_LIST", books);
		}
	    
		// Redirect the user on the same page with every parameters set previously.
	    RequestDispatcher dispatcher = request.getRequestDispatcher("book-manager.jsp");
	    dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		HttpSession session = request.getSession();

		AppUserBean user = new AppUserBean();
		user.setLogin(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		if (appUsersBusinessLocal.getAppUserIfExist(user.getLogin(), user.getPassword()) != null) {
			String username = request.getParameter("username");
			session.setAttribute(USERNAME, username);
			session.setAttribute(LOGIN_INCORRECT, "");
		}
		else {
			session.setAttribute(LOGIN_INCORRECT, "Login/Password incorrect");
		}
				
		String username = request.getParameter("username");
		request.setAttribute("USERNAME", username);
		
		List<BookBean> books = this.booksBusinessLocal.getBooksList();
	    request.setAttribute("BOOKS_LIST", books);
	 	response.sendRedirect("book-manager");
	}
}
