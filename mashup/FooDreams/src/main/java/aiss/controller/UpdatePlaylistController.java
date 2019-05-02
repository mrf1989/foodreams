package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Playlists;

/**
 * Servlet implementation class UpdatePlaylistController
 */
public class UpdatePlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(UpdatePlaylistController.class.getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		String playlistId = request.getParameter("id");
		String id = request.getParameter("playlistId");
		String title = request.getParameter("titulo");
		String description = request.getParameter("descripcion");
		
		if (accessToken != null && !"".equals(accessToken)) {
			YoutubeResource ytResource = new YoutubeResource(accessToken);
			
			if (playlistId != null) {
				Playlists playlist = ytResource.getPlaylist(playlistId);
				
				if (playlist != null && playlist.getItems().size() > 0 && playlist.getItems().get(0) != null) {
					request.setAttribute("playlist", playlist.getItems().get(0));
					request.getRequestDispatcher("/formPlaylists.jsp").forward(request, response);
				} else {
					log.log(Level.WARNING, "No existe la playlist.");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}	
			} else {
				boolean updatedPlaylist = ytResource.updatePlaylist(id, "fooDreams - " + title, description);
				
				if (updatedPlaylist) {
					log.log(Level.INFO, "Playlist actualizada con éxito.");
					request.getRequestDispatcher("/youtubePlaylists").forward(request, response);
				} else {
					log.log(Level.WARNING, "No se pudo actualizar la playlist.");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			}
			
		} else {
			log.log(Level.INFO, "Intentando acceder al servicio de playlists de Youtube sin accessToken. Redirigiendo al OAuth servlet.");
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
