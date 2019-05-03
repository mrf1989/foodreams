package aiss.model.foodreams;

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
		alergenos.remove(a);
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
		if (i != null) {
			ingredientes.remove(i);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alergenos == null) ? 0 : alergenos.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaPublicacion == null) ? 0 : fechaPublicacion.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
		result = prime * result + ((nComensales == null) ? 0 : nComensales.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (alergenos == null) {
			if (other.alergenos != null)
				return false;
		} else if (!alergenos.equals(other.alergenos))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaPublicacion == null) {
			if (other.fechaPublicacion != null)
				return false;
		} else if (!fechaPublicacion.equals(other.fechaPublicacion))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredientes == null) {
			if (other.ingredientes != null)
				return false;
		} else if (!ingredientes.equals(other.ingredientes))
			return false;
		if (nComensales == null) {
			if (other.nComensales != null)
				return false;
		} else if (!nComensales.equals(other.nComensales))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
