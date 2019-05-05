package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.youtube.VideoSearch;

public class YoutubeResourceTest {
	
	@Test
	public void testGetVideos() throws UnsupportedEncodingException {
		String receta = "macarrones con queso";
		
		System.out.println("Test Youtube 1: solicitando vídeos con parámetro q: " + receta);
		
		YoutubeResource recurso = new YoutubeResource();
		VideoSearch videos = recurso.getVideos(receta);
		
		if (videos.getItems().isEmpty() ) {
			videos = null;
		} else {
			System.out.println("Test Youtube 1: se han obtenido resultados.");
		}
		
		assertNotNull("El objeto devuelto no puede ser null.", videos);
		assertNotNull("La lista de vídeos no puede ser null.", videos.getItems());
		
	}

}
