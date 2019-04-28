package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Receta;
import aiss.model.repository.FooDreamsRepository;
import aiss.model.repository.MapFooDreamsRepository;

@Path("/recetas")
public class RecetaResource {

	private static RecetaResource _instance=null;
	FooDreamsRepository repository;
	
	private RecetaResource() {
		repository=MapFooDreamsRepository.getInstance();
	}
	public static RecetaResource getInstance()
	{
		if(_instance==null)
				_instance=new RecetaResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Receta> getAll(){
		return repository.getAllRecetas();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Receta get(@PathParam("id") String id) {
		Receta receta = repository.getReceta(id);
		
		if(receta==null) {
			throw new NotFoundException("La receta con id="+id+" no ha sido encontrada");
		}
		return receta;
	}

	@DELETE
	@Path("/{id}")
	public Response removeReceta(@PathParam("id") String id) {
		Receta receta = repository.getReceta(id);
		
		if (receta.getId()==null)
			throw new NotFoundException("La receta con id="+id+" no ha sido encontrado");
		
		
		repository.deleteReceta(id);	
		
		return Response.noContent().build();
	}
}
