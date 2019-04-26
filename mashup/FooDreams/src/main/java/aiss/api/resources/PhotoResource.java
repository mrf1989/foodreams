package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.repository.FooDreamsRepository;

@Path("/lists")
public class PhotoResource {

	private static PhotoResource _instance=null;
	FooDreamsRepository repository;
	
	public static PhotoResource getInstance()
	{
		if(_instance==null)
				_instance=new PhotoResource();
		return _instance;
	}
}
