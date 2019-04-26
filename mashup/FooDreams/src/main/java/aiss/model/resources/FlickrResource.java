package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.flickr.FotoSearch;

public class FlickrResource {
	
	private static final String FLICKR_API_KEY = "f2a85fcb72c13d74c8030301d45587ca";
	
	private static final Logger log = Logger.getLogger(FlickrResource.class.getName());
	
	public FotoSearch getFotos(String query) throws UnsupportedEncodingException {
		
		String text = URLEncoder.encode(query, "UTF-8");
		
		String uri = "https://api.flickr.com/services/rest/?method=flickr.photos.search&text=" + text +
				"&api_key=" + FLICKR_API_KEY + "&per_page=9&tags=comida,receta,salud,bienestar"
				+ "&content-type=1&format=json&nojsoncallback=1";
		
		ClientResource cr = new ClientResource(uri);
		FotoSearch fotoSearch = cr.get(FotoSearch.class);
		
		return fotoSearch;
	}

}
