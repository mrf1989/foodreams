package aiss.controller.search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

/**
 * Servlet implementation class VideosController
 */
public class VideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		RequestDispatcher rd = null;
		
		YoutubeResource youtube = new YoutubeResource();
		VideoSearch videosResult = youtube.getVideos(q);
		
		if(videosResult != null) {
			rd = request.getRequestDispatcher("/videos.jsp");
			request.setAttribute("videos", videosResult.getItems());
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
