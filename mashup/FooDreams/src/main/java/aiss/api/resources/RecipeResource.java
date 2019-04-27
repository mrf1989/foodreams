package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.repository.FooDreamsRepository;

@Path("/lists")
public class RecipeResource {

	private static RecipeResource _instance=null;
	FooDreamsRepository repository;
	
	public static RecipeResource getInstance()
	{
		if(_instance==null)
				_instance=new RecipeResource();
		return _instance;
	}

}
