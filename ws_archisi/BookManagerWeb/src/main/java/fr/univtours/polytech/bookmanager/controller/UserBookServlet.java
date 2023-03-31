package fr.univtours.polytech.bookmanager.controller;

import java.io.IOException;

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
import fr.univtours.polytech.bookmanager.business.GenresBusinessLocal;

/**
 * Servlet implementation class UserBookServlet
 */
@WebServlet(name = "UserBookServlet", urlPatterns = { "/book-manager-user" })
public class UserBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@EJB
	private BooksBusinessLocal booksBusinessLocal;

	@EJB
	private AuthorsBusinessLocal authorsBusinessLocal;

	@EJB
	private AppUsersBusinessLocal appUsersBusinessLocal;

	@EJB
	private GenresBusinessLocal genresBusinessLocal;

	private static String PRIVILEGE = "PRIVILEGE";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute(PRIVILEGE) == "USER"){
			RequestDispatcher dispatcher = request.getRequestDispatcher("book-manager-user.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("book-manager");
		}
	}
}
