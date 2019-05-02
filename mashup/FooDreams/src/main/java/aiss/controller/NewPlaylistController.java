package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;

/**
 * Servlet implementation class NewPlaylistController
 */
public class NewPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(NewPlaylistController.class.getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		String title = request.getParameter("titulo");
		String description = request.getParameter("descripcion");
		
		if (accessToken != null && !"".equals(accessToken)) {
			YoutubeResource ytResource = new YoutubeResource(accessToken);
			log.log(Level.INFO, "Tratando de crear la playlist: " + title);
			boolean newPlaylist = ytResource.insertPlaylist(title, description);
			
			if (newPlaylist) {
				log.log(Level.FINE, "Nueva playlist creada con éxito.");
				request.getRequestDispatcher("/youtubePlaylists").forward(request, response);
			} else {
				log.log(Level.WARNING, "No se pudo crear la playlist.");
				request.setAttribute("error", "No pudo crear la playlist.");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}

		} else {
			log.info("Intentando acceder al servicio de playlists de Youtube sin accessToken. Redirigiendo al OAuth servlet");
			request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
