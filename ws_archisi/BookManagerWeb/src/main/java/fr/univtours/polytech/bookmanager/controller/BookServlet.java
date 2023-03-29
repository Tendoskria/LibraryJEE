package fr.univtours.polytech.bookmanager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(name = "BookServlet", urlPatterns = { "/book-manager" })
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupère les notes en base.
	    /*List<NoteBean> notes = this.noteBusinessLocal.getNotesList();
	    request.setAttribute("LISTE_NOTES", notes);
	    
	    Float mean = this.noteBusinessLocal.computeMean(notes);
	    request.setAttribute("MEAN", mean);*/

	    RequestDispatcher dispatcher = request.getRequestDispatcher("book-manager.jsp");
	    dispatcher.forward(request, response);
	}
}
