package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.foodreams.Ingrediente;
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
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addIngrediente(@Context UriInfo uriInfo, Ingrediente ingrediente) {
		if (ingrediente.getNombre() == null || "".equals(ingrediente.getNombre())) {
			throw new BadRequestException("El nombre del ingrediente no debe ser null");
		}
		if (ingrediente.getId()!=null)
			throw new BadRequestException("La propiedad id no puede editarse.");

		repository.addIngrediente(ingrediente);

		// Builds the response. Returns the song the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(ingrediente.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(ingrediente);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateIngrediente(Ingrediente ingrediente) {
		Ingrediente oldingrediente = repository.getIngrediente(ingrediente.getId());
		if (oldingrediente == null) {
			throw new NotFoundException("El ingrediente con id="+ ingrediente.getId() +" no ha sido encontrado");			
		}
		// Actualizar nombre
		if (ingrediente.getNombre()!=null)
			oldingrediente.setNombre(ingrediente.getNombre());
		
		// Actualizar cantidad
		if(ingrediente.getCantidad()!=null)
			oldingrediente.setCantidad(ingrediente.getCantidad());
		
		// Actualizar unidad 
		if (ingrediente.getUnidad()!=null) {
			oldingrediente.setUnidad(ingrediente.getUnidad());
		}
		
		// Actualizar calorías
		if (ingrediente.getCalorias()!= null) {
			oldingrediente.setCalorias(ingrediente.getCalorias());
			
		}

		return Response.noContent().build();
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
