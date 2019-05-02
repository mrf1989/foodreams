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
 * Servlet implementation class DeletePlaylistController
 */
public class DeletePlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(DeletePlaylistController.class.getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		String playlistId = request.getParameter("playlistId");
		
		if (accessToken != null && !"".equals(accessToken)) {
			YoutubeResource ytResource = new YoutubeResource(accessToken);
			log.log(Level.INFO, "Tratando de eliminar la playlist: " + playlistId);
			boolean deletePlaylist = ytResource.deletePlaylist(playlistId);
			
			if (deletePlaylist) {
				log.log(Level.FINE, "Playlist eliminada con éxito.");
				request.getRequestDispatcher("/youtubePlaylists").forward(request, response);
			} else {
				log.log(Level.WARNING, "No se pudo eliminar la playlist.");
				request.setAttribute("error", "No se pudo borrar la playlist.");
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
