 package aiss.model;

public class Ingrediente {

	private String id;
	private String nombre;
	private String cantidad;
	private String unidad;
	private String calorías;

	public Ingrediente() {

	}

	public Ingrediente(String nombre, String cantidad, String unidad, String calorías) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.calorías = calorías;
	}

	public Ingrediente(String id, String nombre, String cantidad, String unidad, String calorías) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.calorías = calorías;
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

	public String getCalorías() {
		return calorías;
	}

	public void setCalorías(String calorías) {
		this.calorías = calorías;
	}

}
