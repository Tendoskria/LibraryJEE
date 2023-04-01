package fr.univtours.polytech.bookmanager.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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
import fr.univtours.polytech.bookmanager.business.BorrowsBusinessLocal;
import fr.univtours.polytech.bookmanager.business.GenresBusinessLocal;
import fr.univtours.polytech.bookmanager.model.AppUserBean;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;
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

	@EJB
	private BorrowsBusinessLocal borrowsBusinessLocal;

	private static String USERNAME = "USERNAME";
	private static String LOGIN_INCORRECT = "LOGIN_INCORRECT";
	private static String PRIVILEGE = "PRIVILEGE";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the content of the filters fields.
		String titleFilter = request.getParameter("title");
		String authorFilter = request.getParameter("author");
		String genreFilter = request.getParameter("genre");

		List<GenreBean> genres = this.genresBusinessLocal.getGenresList();
		request.setAttribute("GENRES_LIST", genres);

		// If every filters fields empty means that there is no research. Consequently,
		// show every book in base.
		if (titleFilter == null && authorFilter == null && genreFilter == null) {
			List<BookBean> books = this.booksBusinessLocal.getBooksList();
			request.setAttribute("BOOKS_LIST", books);

			List<BookBean> booksAvailable = this.borrowsBusinessLocal.getBooksAvailable(books);
			request.setAttribute("BOOKS_AVAILABLE", booksAvailable);
		} else {
			List<BookBean> books = this.booksBusinessLocal.getFilteredBook(titleFilter, authorFilter, genreFilter);
			request.setAttribute("BOOKS_LIST", books);

			List<BookBean> booksAvailable = this.borrowsBusinessLocal.getBooksAvailable(books);
			request.setAttribute("BOOKS_AVAILABLE", booksAvailable);
		}

		// Redirect the user on the same page with every parameters set previously.
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-manager.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (request.getParameter("login") != null) {
			AppUserBean user = new AppUserBean();
			user.setLogin(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			if (appUsersBusinessLocal.getAppUserIfExist(user.getLogin(), user.getPassword()) != null) {
				String username = request.getParameter("username");
				session.setAttribute(getUSERNAME(), username);
				session.setAttribute(LOGIN_INCORRECT, "");
				user = appUsersBusinessLocal.getAppUser(username);
				if (user.getPrivilege() == true)
					session.setAttribute(PRIVILEGE, "ADMIN");
				else
					session.setAttribute(PRIVILEGE, "USER");
			} else {
				session.setAttribute(LOGIN_INCORRECT, "Login/Password incorrect");
			}

			String username = request.getParameter("username");
			request.setAttribute("USERNAME", username);

			List<BookBean> books = this.booksBusinessLocal.getBooksList();
			request.setAttribute("BOOKS_LIST", books);
			response.sendRedirect("book-manager");
		}
		
		if (request.getParameter("borrow") != null){
			BookBean book = booksBusinessLocal.getBook(Integer.valueOf(request.getParameter("borrow")));
			String username = (String) session.getAttribute(getUSERNAME());
			AppUserBean user = appUsersBusinessLocal.getAppUser(username);
						
			BorrowBean borrow = new BorrowBean();
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			calendar.add(Calendar.DATE, 10);
			Date currentDateMoreTen = calendar.getTime();

			java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
			java.sql.Date sqlDateMoreTen = new java.sql.Date(currentDateMoreTen.getTime());
			
			borrow.setBook(book);
			borrow.setStartingDate(sqlDate);
			borrow.setEndingDate(sqlDateMoreTen);
			borrow.setUser(user);
			borrow.setIsBorrowEnd(false);
			
			borrowsBusinessLocal.insertBorrow(borrow);
			
			response.sendRedirect("book-manager-user");
		}
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public static void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
}
