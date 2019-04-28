package aiss.model.repository;

import java.util.Collection;

import aiss.model.Ingrediente;
import aiss.model.Receta;

public interface FooDreamsRepository {
	// Ingredientes
	public void addIngrediente(Ingrediente i);

	public Collection<Ingrediente> getAllIngredientes();

	public Ingrediente getIngrediente(String ingredienteId);

	public void updateIngrediente(Ingrediente i);

	public void deleteIngrediente(String ingredienteId);

	// Recetas
	public void addReceta(Receta r);

	public Collection<Receta> getAllRecetas();

	public Receta getReceta(String recetaId);

	public void updateReceta(Receta r);

	public void deleteReceta(String recetaId);

	public Collection<Ingrediente> getAll(String recetaId);

	public void addIngrediente(String recetaId, String ingredienteId);

	public void removeIngrediente(String recetaId, String ingredienteId);

}
