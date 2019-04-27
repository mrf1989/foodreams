package aiss.model.repository;

import java.util.Collection;

import aiss.model.edamam.Ingredient;
import aiss.model.edamam.Recipe;

public interface FooDreamsRepository {

	// Recipes
	public Collection<Recipe> getAllRecipes();
	public Recipe getRecipe(String recipeId);
	
	// Ingredients
	public Collection<Ingredient> getAllIngredients();
	public Ingredient getIngredient(String ingrId);
}
