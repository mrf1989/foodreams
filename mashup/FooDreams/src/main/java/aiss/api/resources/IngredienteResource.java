package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.repository.FooDreamsRepository;
import aiss.model.repository.MapFooDreamsRepository;


@Path("/ingredientes")
public class IngredienteResource {

	private static IngredienteResource instance = null;
	FooDreamsRepository repository;

	private IngredienteResource() {
		repository = MapFooDreamsRepository.getInstance();
	}

	public static IngredienteResource getInstance() {
		if (instance == null)
			instance = new IngredienteResource();
		return instance;
	}
}
