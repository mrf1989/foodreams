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
 * Servlet implementation class AddToPlaylistController
 */
public class AddToPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(AddToPlaylistController.class.getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToPlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		String playlistId = request.getParameter("playlistId");
		String videoId = request.getParameter("videoId");
		String q = request.getParameter("q");
		
		log.log(Level.INFO, "Playlist seleccionada: " + playlistId);
		log.log(Level.INFO, "Elemento a añadir: " + videoId);
		
		if (accessToken != null && !"".equals(accessToken)) {
			YoutubeResource ytResource = new YoutubeResource(accessToken);
			log.log(Level.INFO, "Tratando de añadir: " + videoId + " --> " + playlistId);
			boolean addVideo = ytResource.addVideoToPlaylist(playlistId, videoId);
			
			if (addVideo) {
				log.log(Level.INFO, "Nuevo vídeo añadido con éxito.");
				request.setAttribute("q", q);
				request.setAttribute("alert", "success");
				request.getRequestDispatcher("/VideosController").forward(request, response);
			} else {
				log.log(Level.WARNING, "No se pudo añadir el vídeo a la playlist.");
				request.setAttribute("error", "No se pudo añadir el vídeo a la playlist.");
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
