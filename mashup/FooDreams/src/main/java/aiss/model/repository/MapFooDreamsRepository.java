package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.Ingrediente;
import aiss.model.Receta;

public class MapFooDreamsRepository implements FooDreamsRepository {
	Map<String, Receta> recetaMap;
	Map<String, Ingrediente> ingredienteMap;
	private static MapFooDreamsRepository instance = null;
	private int index = 0;

	public static MapFooDreamsRepository getInstance() {
		if (instance == null) {
			instance = new MapFooDreamsRepository();
			instance.init();
		}
		return instance;
	}

	private void init() {
		recetaMap=new HashMap<String, Receta>();
		ingredienteMap= new HashMap<String, Ingrediente>();
		
		//Crear ingredientes
		Ingrediente garbanzos=new Ingrediente();
		garbanzos.setNombre("Garbanzo");
		garbanzos.setCantidad("300.0");
		garbanzos.setUnidad("gramos");
		garbanzos.setCalorías("540.0");
		addIngrediente(garbanzos);
		
		Ingrediente tocino=new Ingrediente();
		tocino.setNombre("Tocino");
		tocino.setCantidad("200.0");
		tocino.setUnidad("gramos");
		tocino.setCalorías("1082.0");
		addIngrediente(tocino);
		
		//Crear recetas 
		Receta cocidoMadrileño= new Receta();
		cocidoMadrileño.setFechaPublicacion("2018-03-02");
		cocidoMadrileño.setNombre("Cocido madrileño");
		cocidoMadrileño.setDescripcion("Remojar los garbanzos la noche anterior en agua templada" + 
				" con un poco de sal. A la mañana siguiente, sacarlos y escurrirlos. Colocar" + 
				" en una cazuela grande...");
		cocidoMadrileño.setFoto("");
		cocidoMadrileño.setnComensales("6");
		List<String> s=new ArrayList<String>();
		s.add("huevo"); s.add("gluten");
		cocidoMadrileño.setAlergenos(s);
		addReceta(cocidoMadrileño);
		
		//Añadir ingredientes a las recetas
		addIngrediente(cocidoMadrileño.getId(), garbanzos.getId());
		addIngrediente(cocidoMadrileño.getId(), tocino.getId());
	}

	@Override
	public void addIngrediente(Ingrediente i) {
		String id= "i"+ index++;
		i.setId(id);
		ingredienteMap.put(id, i);
	}

	@Override
	public Collection<Ingrediente> getAllIngredientes() {
		return ingredienteMap.values();
	}

	@Override
	public Ingrediente getIngrediente(String ingredienteId) {
		return ingredienteMap.get(ingredienteId);
	}

	@Override
	public void updateIngrediente(Ingrediente i) {
		Ingrediente ingrediente= ingredienteMap.get(i.getId());
		ingrediente.setNombre(i.getNombre());
		ingrediente.setCantidad(i.getCantidad());
		ingrediente.setUnidad(i.getUnidad());
		ingrediente.setCalorías(i.getCalorías());
	}

	@Override
	public void deleteIngrediente(String ingredienteId) {
		ingredienteMap.remove(ingredienteId);
	}

	@Override
	public void addReceta(Receta r) {
		String id="r"+ index++;
		r.setId(id);
		recetaMap.put(id, r);
	}

	@Override
	public Collection<Receta> getAllRecetas() {
		return recetaMap.values();
	}

	@Override
	public Receta getReceta(String recetaId) {
		return recetaMap.get(recetaId);
	}

	@Override
	public void updateReceta(Receta r) {
		recetaMap.put(r.getId(), r);
	}

	@Override
	public void deleteReceta(String recetaId) {
		recetaMap.remove(recetaId);
	}

	@Override
	public Collection<Ingrediente> getAll(String recetaId) {
		return getReceta(recetaId).getIngredientes();
	}

	@Override
	public void addIngrediente(String recetaId, String ingredienteId) {
		Receta receta= getReceta(recetaId);
		receta.addIngrediente(ingredienteMap.get(ingredienteId));
	}

	@Override
	public void removeIngrediente(String recetaId, String ingredienteId) {
		getReceta(recetaId).deleteIngrediente(ingredienteId);
	}

}
