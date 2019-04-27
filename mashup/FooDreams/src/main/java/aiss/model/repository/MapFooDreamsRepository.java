package aiss.model.repository;

import java.util.Collection;
import java.util.Map;

import aiss.model.edamam.Ingredient;
import aiss.model.edamam.Recipe;

public class MapFooDreamsRepository implements FooDreamsRepository{
	
	Map<String, Recipe> recipeMap;
	Map<String, Ingredient> ingredientMap;
	private static MapFooDreamsRepository instance=null;
//	private int index=0;
	
	
	public static MapFooDreamsRepository getInstance() {
		
		if (instance==null) {
			instance = new MapFooDreamsRepository();
			instance.init();
		}
		
		return instance;
	}


	private void init() {
	// TODO Auto-generated method stub
	
}


	@Override
	public Collection<Recipe> getAllRecipes() {
		return recipeMap.values();
	}


	@Override
	public Recipe getRecipe(String recipeId) {
		return recipeMap.get(recipeId);
	}


	@Override
	public Collection<Ingredient> getAllIngredients() {
		return ingredientMap.values();
	}


	@Override
	public Ingredient getIngredient(String ingrId) {
		return ingredientMap.get(ingrId);
	}

	
	
}
