package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.edamam.RecetaSearch;

public class EdamamResourceTest {

	@Test
	public void testGetRecetas1() throws UnsupportedEncodingException {
		String receta = "macarrones con chorizo";
		String tipoDieta = "balanced";
		String ingr = "10";
		
		System.out.println("Test Edamam 1: solicitando recetas con parámetros q, diet y ingr.");
		
		EdamamResource edamam = new EdamamResource();
		RecetaSearch recetas = edamam.getRecetas(receta, tipoDieta, ingr);
		
		if (recetas.getHits().isEmpty()) {
			recetas = null;
		} else {
			System.out.println("Test Edamam 1: se han obtenido resultados.");
		}
		
		assertNotNull("El objeto devuelto no puede ser null", recetas);
		assertNotNull("La lista de recetas no puede ser null", recetas.getHits());
	}
	
	@Test
	public void testGetRecetas2() throws UnsupportedEncodingException {
		String receta = "macarrones con chorizo";
		String tipoDieta = "balanced";
		
		System.out.println("Test Edamam 2: solicitando recetas con parámetros q y diet.");
		
		EdamamResource edamam = new EdamamResource();
		RecetaSearch recetas = edamam.getRecetas(receta, tipoDieta, "");
		
		if (recetas.getHits().isEmpty()) {
			recetas = null;
		} else {
			System.out.println("Test Edamam 2: se han obtenido resultados.");
		}
		
		assertNotNull("El objeto devuelto no puede ser null", recetas);
		assertNotNull("La lista de recetas no puede ser null", recetas.getHits());
	}
	
	@Test
	public void testGetRecetas3() throws UnsupportedEncodingException {
		String receta = "macarrones con chorizo";
		String ingr = "10";
		
		System.out.println("Test Edamam 3: solicitando recetas con parámetros q y ingr.");
		
		EdamamResource edamam = new EdamamResource();
		RecetaSearch recetas = edamam.getRecetas(receta, "", ingr);
		
		if (recetas.getHits().isEmpty()) {
			recetas = null;
		} else {
			System.out.println("Test Edamam 3: se han obtenido resultados.");
		}
		
		assertNotNull("El objeto devuelto no puede ser null", recetas);
		assertNotNull("La lista de recetas no puede ser null", recetas.getHits());
	}
	
	@Test
	public void testGetRecetas4() throws UnsupportedEncodingException {
		String receta = "macarrones con chorizo";
		
		System.out.println("Test Edamam 4: solicitando recetas con parámetro q.");
		
		EdamamResource edamam = new EdamamResource();
		RecetaSearch recetas = edamam.getRecetas(receta, "", "");
		
		if (recetas.getHits().isEmpty()) {
			recetas = null;
		} else {
			System.out.println("Test Edamam 4: se han obtenido resultados.");
		}
		
		assertNotNull("El objeto devuelto no puede ser null", recetas);
		assertNotNull("La lista de recetas no puede ser null", recetas.getHits());
	}

}
