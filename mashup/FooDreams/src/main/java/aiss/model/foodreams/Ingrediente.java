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

}
