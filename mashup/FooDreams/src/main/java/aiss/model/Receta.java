package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Receta {

	private String id;
	private String fechaPublicacion;
	private String nombre;
	private String descripcion;
	private String foto;
	private String nComensales;
	private List<String> alergenos;
	private List<Ingrediente> ingredientes;

	public Receta() {
	}
	

	public Receta(String fechaPublicacion, String nombre, String descripcion, String foto, String nComensales,
			List<String> alergenos) {
		super();
		this.fechaPublicacion = fechaPublicacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.nComensales = nComensales;
		this.alergenos = alergenos;
	}


	public Receta(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getnComensales() {
		return nComensales;
	}

	public void setnComensales(String nComensales) {
		this.nComensales = nComensales;
	}

	public List<String> getAlergenos() {
		return alergenos;
	}

	public void setAlergenos(List<String> alergenos) {
		this.alergenos = alergenos;
	}
	public void addAlergenos(String a) {
		if (alergenos == null)
			alergenos = new ArrayList<>();
			alergenos.add(a);
	}

	public void deleteAlergenos(String a) {
		ingredientes.remove(a);
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public Ingrediente getIngrediente(String id) {
		if (ingredientes == null) {
			return null;
		}
		Ingrediente ingrediente = null;
		for (Ingrediente i : ingredientes)
			if (i.getId().equals(id)) {
				ingrediente = i;
				break;
			}

		return ingrediente;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void addIngrediente(Ingrediente i) {
		if (ingredientes == null)
			ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(i);
	}

	public void deleteIngrediente(Ingrediente i) {
		ingredientes.remove(i);
	}

	public void deleteIngrediente(String id) {
		Ingrediente i = getIngrediente(id);
		if (i != null)
			ingredientes.remove(i);
	}

}
