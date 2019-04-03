package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.youtube.VideoSearch;

public class YoutubeResource {
	
	private static final String YOUTUBE_API_KEY = "AIzaSyAor0IdwSo8mqy3vbaGatcqdnErzMKH3Js";
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	
	public VideoSearch getVideos(String query) throws UnsupportedEncodingException {
		
		String q = URLEncoder.encode(query, "UTF-8");
		
		String uri = "https://www.googleapis.com/youtube/v3/search?key=" + YOUTUBE_API_KEY + 
				"&part=snippet&q=" + q;
		
		ClientResource cr = new ClientResource(uri);
		VideoSearch vs = cr.get(VideoSearch.class);
		
		
		return vs;
		
	}
	

}
