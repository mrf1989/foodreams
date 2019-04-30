package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.NewPlaylist;
import aiss.model.youtube.Playlists;
import aiss.model.youtube.Snippet_;
import aiss.model.youtube.Status;
import aiss.model.youtube.VideoSearch;

public class YoutubeResource {
	
	private static final String YOUTUBE_API_KEY = "AIzaSyAor0IdwSo8mqy3vbaGatcqdnErzMKH3Js";
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	
	private final String access_token;
	private final String baseURL = "https://www.googleapis.com/youtube/v3";
	
	public YoutubeResource() {
		this.access_token = null;
	}
	
	public YoutubeResource(String access_token) {
		this.access_token = access_token;
	}
	
	public VideoSearch getVideos(String query) throws UnsupportedEncodingException {
		String q = URLEncoder.encode(query, "UTF-8");
		
		String uri = baseURL + "/search?key=" + YOUTUBE_API_KEY + "&part=snippet&q=" + q +"&maxResults=8";
		
		ClientResource cr = new ClientResource(uri);
		VideoSearch vs = cr.get(VideoSearch.class);
		
		return vs;	
	}
	
	public Playlists getPlaylists() throws UnsupportedEncodingException {
		String uri = baseURL + "/playlists?part=snippet&mine=true&maxResults=10";
		ClientResource cr = new ClientResource(uri);
		
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        Playlists playlists = null;
        try {
        	playlists = cr.get(Playlists.class);
        	return playlists;
			
		} catch (ResourceException re) {
			log.warning("Error al solicitar las playlists: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
	}
	
	public boolean insertPlaylist(String title, String description) throws UnsupportedEncodingException {
		String uri = baseURL + "/playlists?part=snippet,status";
		ClientResource cr = new ClientResource(uri);
		
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        Snippet_ newPlaylist = new Snippet_();
        Status newPlaylistStatus = new Status();
        
        newPlaylist.setTitle("fooDreams - " + title);
        newPlaylist.setDescription(description);
        newPlaylistStatus.setPrivacyStatus("public");
        
        NewPlaylist p = new NewPlaylist();
        p.setSnippet(newPlaylist);
        p.setStatus(newPlaylistStatus);
        
        try {
			cr.post(p, MediaType.APPLICATION_ALL_JSON);
			return true;
		} catch (ResourceException re) {
			log.warning("Error al insertar una nueva playlist: " + cr.getResponse().getStatus());
			log.warning(uri);
			return false;
		}
	}

}
