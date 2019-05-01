package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.edamam.RecetaSearch;
import aiss.model.resources.EdamamResource;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		String diet = request.getParameter("diet");
		String ingr = request.getParameter("ingr");
		
		RequestDispatcher rd = null;
		
		log.log(Level.FINE, "Buscando en Edamam recetas de " + q);
		log.log(Level.FINE, "Buscando recetas de dieta: " + diet);
		log.log(Level.FINE, "Buscando recetas de un máximo de ingredientes: " + ingr);
		
		EdamamResource edamam = new EdamamResource();
		RecetaSearch edamamResults = edamam.getRecetas(q, diet, ingr);
		
		if (edamamResults != null) {
			log.log(Level.FINE, "Total de recetas encontradas: " + edamamResults.getHits().size());
			rd = request.getRequestDispatcher("/recetas.jsp");
			request.setAttribute("recetas", edamamResults.getHits());
		} else {
			log.log(Level.WARNING, "No se encontraron recetas");
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
