package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.repository.FooDreamsRepository;

@Path("/lists")
public class FoodResource {

	private static FoodResource _instance=null;
	FooDreamsRepository repository;
	
	public static FoodResource getInstance()
	{
		if(_instance==null)
				_instance=new FoodResource();
		return _instance;
	}

}
