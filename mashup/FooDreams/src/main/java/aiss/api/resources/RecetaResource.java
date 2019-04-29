package aiss.api.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

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

import aiss.model.Ingrediente;
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
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addReceta(@Context UriInfo uriInfo, Receta receta) {
		if (receta.getNombre() == null || "".equals(receta.getNombre()))
			throw new BadRequestException("El nombre de la receta no debe ser nulo");
		
		if (receta.getFechaPublicacion()!=null)
			throw new BadRequestException("La propiedad fecha de publicación no se puede modificar.");
		
			receta.setFechaPublicacion(LocalDate.now().toString());
		
		if (receta.getIngredientes()!=null)
			throw new BadRequestException("La propiedad ingrediente no se puede modificar.");

		repository.addReceta(receta);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(receta.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(receta);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateReceta(Receta receta) {
		Receta oldreceta = repository.getReceta(receta.getId());
		if (oldreceta == null) {
			throw new NotFoundException("La receta con id="+ receta.getId() +" no ha sido encontrada");			
		}
		
		if (receta.getIngredientes()!=null)
			throw new BadRequestException("La propiedad ingrediente no se puede modificar.");
		if (receta.getFechaPublicacion()!=null)
			throw new BadRequestException("La propiedad fecha de publicación no se puede modificar.");
	
		// Actualizar nombre
		if (receta.getNombre()!=null)
			oldreceta.setNombre(receta.getNombre());
		
		// Actualizar descripción
		if (receta.getDescripcion()!=null)
			oldreceta.setDescripcion(receta.getDescripcion());
		
		//Actualizar foto
		if (receta.getFoto()!=null)
			oldreceta.setFoto(receta.getFoto());
		//Actualizar numero de comensales
		if(receta.getnComensales()!=null)
			oldreceta.setnComensales(receta.getnComensales());
		//Actualizar alergenos
		if(receta.getAlergenos()!=null)
			oldreceta.setAlergenos(receta.getAlergenos());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeReceta(@PathParam("id") String id) {
		Receta receta = repository.getReceta(id);
		
		if (receta.getId()==null)
			throw new NotFoundException("La receta con id="+id+" no ha sido encontrada");
		
		
		repository.deleteReceta(id);	
		
		return Response.noContent().build();
	}
	
	//ingrediente
	
	@POST	
	@Path("/{recetaId}/{ingredienteId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addIngrediente(@Context UriInfo uriInfo,@PathParam("recetaId") String recetaId, @PathParam("ingredienteId") String ingredienteId)
	{				
		
		Receta receta = repository.getReceta(recetaId);
		Ingrediente ingrediente = repository.getIngrediente(ingredienteId);
		
		if (receta==null)
			throw new NotFoundException("La receta con id=" + recetaId + " no ha sido encontrada");
		
		if (ingrediente == null)
			throw new NotFoundException("El ingrediente con id=" + ingredienteId + " no ha sido encontrado");
		
		if (receta.getIngrediente(ingredienteId)!=null)
			throw new BadRequestException("El ingrediente ya estaba incluido en la receta.");
			
		repository.addIngrediente(recetaId, ingredienteId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(recetaId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(receta);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{recetaId}/{ingredienteId}")
	public Response removeIngrediente(@PathParam("recetaId") String recetaId, @PathParam("ingredienteId") String ingredienteId) {
		Receta receta = repository.getReceta(recetaId);
		Ingrediente ingrediente = repository.getIngrediente(ingredienteId);
		
		if (receta==null)
			throw new NotFoundException("La receta con id=" + recetaId + " no ha sido encontrada");
		
		if (ingrediente == null)
			throw new NotFoundException("El ingrediente con id=" + ingredienteId + " no ha sido encontrado");
		
		
		repository.removeIngrediente(recetaId, ingredienteId);	
		
		return Response.noContent().build();
	}		
}
