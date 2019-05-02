package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.flickr.FotoSearch;
import aiss.model.resources.FlickrResource;

/**
 * Servlet implementation class PhotosController
 */
public class PhotosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchController.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		RequestDispatcher rd = null;

		log.log(Level.FINE, "Buscando en Flickr fotos de: " + q);
		
		FlickrResource flickr = new FlickrResource();
		FotoSearch flickrResults = flickr.getFotos(q);
		
		if (flickrResults != null) {
			log.log(Level.FINE, "Total de fotos encontradas: " + flickrResults.getPhotos().getPhoto().size());
			rd = request.getRequestDispatcher("/fotos.jsp");
			request.setAttribute("fotos", flickrResults.getPhotos().getPhoto());
		} else {
			log.log(Level.WARNING, "No se han obtenido fotos.");
			request.setAttribute("error", "No se encontraron fotos para los términos de búsqueda introducidos.");
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
