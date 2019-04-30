package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.flickr.FotoSearch;

public class FlickrResourceTest {

	@Test
	public void testGetFotos() throws UnsupportedEncodingException {
		String receta = "macarrones con queso";
		
		System.out.println("Test Flickr 1: solicitando fotos con parámetro text: " + receta);
		
		FlickrResource flickr = new FlickrResource();
		FotoSearch fotos = flickr.getFotos(receta);
		
		if (fotos.getPhotos().getPhoto().isEmpty()) {
			fotos = null;
		} else {
			System.out.println("Test Flickr 1: se han obtenido resultados.");
		}
		
		assertNotNull("El objeto devuelto no puede ser null", fotos);
		assertNotNull("La lista de recetas no puede ser null", fotos.getPhotos().getPhoto());
	}

}
