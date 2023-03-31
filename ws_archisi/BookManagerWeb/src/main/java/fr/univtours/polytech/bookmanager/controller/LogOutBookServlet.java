package fr.univtours.polytech.bookmanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestBookServlet
 */
@WebServlet(name = "LogOutBookServlet", urlPatterns = { "/log-out-book-servlet" })
public class LogOutBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private static String PRIVILEGE = "PRIVILEGE";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer la session
				HttpSession session = request.getSession();
				
				// Invalidier la session
				session.invalidate();
				
				// Rediriger l'utilisateur vers la page d'accueil
				response.sendRedirect("book-manager");
			}

	
		   
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
