package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.edamam.RecetaSearch;

public class EdamamResource {
	
	private static final String EDAMAM_API_KEY = "7cee9fe3eff5f7eb260c628eae0dab21";
	private static final String EDAMAM_APP_ID = "44d70924";
	private static final String BASE_URL = "https://test-es.edamam.com/search?app_id=" + EDAMAM_APP_ID +
			"&app_key=" + EDAMAM_API_KEY + "&to=10";
	
	private static final Logger log = Logger.getLogger(EdamamResource.class.getName());
	
	public RecetaSearch getRecetas(String query, String dieta, String ingredientes) throws UnsupportedEncodingException {
		String uri;
		String q = URLEncoder.encode(query, "UTF-8");
		String diet = URLEncoder.encode(dieta, "UTF-8");
		String ingr = URLEncoder.encode(ingredientes, "UTF-8");
		
		if (!diet.equals("") && !ingr.equals("")) {
			uri = BASE_URL + "&q=" + q + "&diet=" + diet + "&ingr=" + ingr;
		} else if (!diet.equals("") && ingr.equals("")) {
			uri = BASE_URL + "&q=" + q + "&diet=" + diet;
		} else if (diet.equals("") && !ingr.equals("")) {
			uri = BASE_URL + "&q=" + q + "&ingr=" + ingr;
		} else {
			uri = BASE_URL + "&q=" + q;
		}
		
		log.log(Level.FINE, "Solicitud GET a Edamam API: " + uri);

		ClientResource cr = new ClientResource(uri);
		RecetaSearch recetaSearch = cr.get(RecetaSearch.class);
		
		return recetaSearch;
	}

}
