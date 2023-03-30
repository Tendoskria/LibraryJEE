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

import fr.univtours.polytech.bookmanager.business.AuthorsBusinessLocal;
import fr.univtours.polytech.bookmanager.business.BooksBusinessLocal;
import fr.univtours.polytech.bookmanager.model.AuthorBean;
import fr.univtours.polytech.bookmanager.model.BookBean;

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
	
	private static String USERNAME = "USERNAME";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookBean> books = this.booksBusinessLocal.getBooksList();
	    request.setAttribute("BOOKS_LIST", books);

	    List<AuthorBean> authors = this.authorsBusinessLocal.getAuthorsList();
	    request.setAttribute("AUTHOR_LIST", authors);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("book-manager.jsp");
	    dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute(USERNAME) != null) {
			String username = request.getParameter("username");
			session.setAttribute(USERNAME, username);
		}
		else {
			session.setAttribute(USERNAME, "Anonymous");
		}
		
		
		String username = request.getParameter("username");
		request.setAttribute("USERNAME", username);
		
		List<BookBean> books = this.booksBusinessLocal.getBooksList();
	    request.setAttribute("BOOKS_LIST", books);
	 	response.sendRedirect("book-manager");
		//request.getRequestDispatcher("book-manager.jsp").forward(request, response);
	}
}
