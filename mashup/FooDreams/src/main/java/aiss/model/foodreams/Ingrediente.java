 package aiss.model.foodreams;

public class Ingrediente {

	private String id;
	private String nombre;
	private String cantidad;
	private String unidad;
	private String calorias;

	public Ingrediente() {

	}

	public Ingrediente(String nombre, String cantidad, String unidad, String calorias) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.calorias = calorias;
	}

	public Ingrediente(String id, String nombre, String cantidad, String unidad, String calorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.calorias = calorias;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getCalorias() {
		return calorias;
	}

	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calorias == null) ? 0 : calorias.hashCode());
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (calorias == null) {
			if (other.calorias != null)
				return false;
		} else if (!calorias.equals(other.calorias))
			return false;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		return true;
	}

	
}
