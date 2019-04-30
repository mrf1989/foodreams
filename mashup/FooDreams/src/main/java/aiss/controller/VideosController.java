package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Item_;
import aiss.model.youtube.Playlists;
import aiss.model.youtube.VideoSearch;

/**
 * Servlet implementation class VideosController
 */
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(VideosController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		
		if (accessToken != null && !"".equals(accessToken)) {
			// Solicitud de las playlists de Youtube del usuario
			YoutubeResource ytResource = new YoutubeResource(accessToken);
			Playlists playlists = ytResource.getPlaylists();
			
			List<Item_> fDPlaylists = playlists.getItems();
			for (int i = 0; i < fDPlaylists.size(); i++) {
				if (!fDPlaylists.get(i).getSnippet().getTitle().contains("fooDreams - ")) {
					fDPlaylists.remove(i);
					i--;
				}
			}
			log.log(Level.FINE, "Encontradas " + fDPlaylists.size() + " playlists de FooDreams.");
			
			if (fDPlaylists != null &&  playlists.getItems().size() > 0 && fDPlaylists.get(0) != null) {
				request.setAttribute("playlists", fDPlaylists);
			} else {
				log.log(Level.INFO, "No se encontraron playlists para el usuario");
			}
			
			// Solicitud de los vídeos relacionados con el término de búsqueda
			YoutubeResource youtube = new YoutubeResource();
			VideoSearch videosResult = youtube.getVideos(q);
			
			RequestDispatcher rd = null;

			if(videosResult != null) {
				rd = request.getRequestDispatcher("/videos.jsp");
				request.setAttribute("videos", videosResult.getItems());
			}
			rd.forward(request, response);
			
		} else {
			log.log(Level.WARNING, "Intentando acceder al servicio de playlists de Youtube sin accessToken. Redirigiendo al OAuth servlet");
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
