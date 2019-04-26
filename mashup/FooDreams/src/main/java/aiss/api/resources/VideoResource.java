package aiss.api.resources;

import javax.ws.rs.Path;

import aiss.model.repository.FooDreamsRepository;

@Path("/lists")
public class VideoResource {
	
	private static VideoResource _instance=null;
	FooDreamsRepository repository;
	
	public static VideoResource getInstance()
	{
		if(_instance==null)
				_instance=new VideoResource();
		return _instance;
	}

}
