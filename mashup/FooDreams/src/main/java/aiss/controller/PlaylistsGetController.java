package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Playlists;

/**
 * Servlet implementation class YoutubePlaylistsGetController
 */
public class PlaylistsGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PlaylistsGetController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistsGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		
		if (accessToken != null && !"".equals(accessToken)) {
			YoutubeResource ytResource = new YoutubeResource(accessToken);
			Playlists playlists = ytResource.getPlaylists();
			log.info("Encontradas " + playlists.getItems().size() + " playlists...");
			if (playlists != null && playlists.getItems() != null && playlists.getItems().size() > 0 &&
					playlists.getItems().get(0) != null) {
				request.setAttribute("playlists", playlists.getItems());
				request.getRequestDispatcher("/perfil.jsp").forward(request, response);
			} else {
				log.warning("No se encontraron playlists para el usuario");
				request.getRequestDispatcher("/").forward(request, response);
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
