package aiss.model;

import java.time.LocalDate;
import java.util.List;

public class Receta {
	
	private String id;
	private LocalDate fechaPublicacion;
	private String nombre;
	private String descripcion;
	private String foto;
	private Integer nComensales;
	private List<String> alergenos;
	private List<Ingrediente> ingredientes;
	
	// falta por acabar la clase y no se si estan bien los tipos de los atributos
}
