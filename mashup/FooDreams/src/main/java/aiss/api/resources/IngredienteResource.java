package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Ingrediente;
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
	
	@GET
	@Produces("application/json")
	public Collection<Ingrediente> getAll(){
		return repository.getAllIngredientes();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Ingrediente get(@PathParam("id") String id) {
		Ingrediente ingrediente = repository.getIngrediente(id);
		
		if(ingrediente==null) {
			throw new NotFoundException("El ingrediente con id="+id+" no ha sido encontrado");
		}
		return ingrediente;
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeIngrediente(@PathParam("id") String id) {
		Ingrediente ingrediente = repository.getIngrediente(id);
		
		if (ingrediente.getId()==null)
			throw new NotFoundException("El ingrediente con id="+id+" no ha sido encontrado");
		
		
		repository.deleteIngrediente(id);	
		
		return Response.noContent().build();
	}
	
	
}
