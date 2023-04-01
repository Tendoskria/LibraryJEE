package fr.univtours.polytech.bookmanager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univtours.polytech.bookmanager.business.BooksBusinessLocal;
import fr.univtours.polytech.bookmanager.business.BorrowsBusinessLocal;
import fr.univtours.polytech.bookmanager.model.BookBean;
import fr.univtours.polytech.bookmanager.model.BorrowBean;

@WebServlet(name = "BookManagerServlet", urlPatterns = { "/book-manager-admin" })
public class BookManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private BorrowsBusinessLocal borrowsBusinessLocal;
	@EJB
	private BooksBusinessLocal booksBusinessLocal;

	private static String PRIVILEGE = "PRIVILEGE";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute(PRIVILEGE) == "ADMIN") {

			List<BorrowBean> borrows = this.borrowsBusinessLocal.getBorrowsList();
			List<BorrowBean> currentBorrows = new ArrayList<>();
			for (BorrowBean borrow : borrows) {
				if (!borrow.getIsBorrowEnd()) {
					currentBorrows.add(borrow);
				}
			}
			request.setAttribute("BORROWS", currentBorrows);

			RequestDispatcher dispatcher = request.getRequestDispatcher("book-manager-admin.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("book-manager");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idBook = Integer.parseInt(request.getParameter("idBook"));
		BookBean book = this.booksBusinessLocal.getBook(idBook);

		BorrowBean borrow = this.borrowsBusinessLocal.getCurrentBorrowOfBook(book);

		this.borrowsBusinessLocal.updateBorrow(borrow);

		response.sendRedirect("book-manager-admin");
	}
}
