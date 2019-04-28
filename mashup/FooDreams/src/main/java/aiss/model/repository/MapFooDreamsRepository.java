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
		recetaMap = new HashMap<String, Receta>();
		ingredienteMap = new HashMap<String, Ingrediente>();

		// Crear ingredientes
		Ingrediente garbanzos = new Ingrediente("Garbanzo", "300.0", "gramos", "540.0");
		addIngrediente(garbanzos);

		Ingrediente tocino = new Ingrediente("Tocino", "200.0", "gramos", "1082.0");
		addIngrediente(tocino);

		// Crear recetas
		List<String> s = new ArrayList<String>();
		s.add("huevo");
		s.add("gluten");
		Receta cocidoMadrileño = new Receta("2018-03-02", "Cocido madrileño",
				"Remojar los garbanzos la noche anterior en agua templada"
						+ " con un poco de sal. A la mañana siguiente, sacarlos y escurrirlos. Colocar"
						+ " en una cazuela grande...", "http://foodreams.appspot.com/media/cocido-madrid-2018-03-02.jpg", "6", s);
		addReceta(cocidoMadrileño);
		
		List<String> s1 = new ArrayList<String>();
		s1.add("huevo");
		s1.add("gluten");
		Receta bizcocho= new Receta("2019-02-01", "Bizcocho ", "En primer lugar, batimos los huevos junto con el yogur, el azúcar, el aceite, la harina y la levadura."+
				"Cuando la masa esté lista, la incorporamos a un molde engrasado y horneamos a 180º C durante 40 minutos en un molde grande."+
				"Pasado ese tiempo sacamos del horno, dejamos enfriar y servimos con un poco de azúcar glass por encima.", "http://foodreams.appspot.com/media/bizcocho-2019-02-01.jpg", "5", s1);
		addReceta(bizcocho);

		// Añadir ingredientes a las recetas
		addIngrediente(cocidoMadrileño.getId(), garbanzos.getId());
		addIngrediente(cocidoMadrileño.getId(), tocino.getId());
	}

	@Override
	public void addIngrediente(Ingrediente i) {
		String id = "i" + index++;
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
		Ingrediente ingrediente = ingredienteMap.get(i.getId());
		ingrediente.setNombre(i.getNombre());
		ingrediente.setCantidad(i.getCantidad());
		ingrediente.setUnidad(i.getUnidad());
<<<<<<< .mine
		ingrediente.setCalorías(i.getCalorias());
||||||| .r83
		ingrediente.setCalorías(i.getCalorías());
=======
		ingrediente.setCalorias(i.getCalorias());
>>>>>>> .r85
	}

	@Override
	public void deleteIngrediente(String ingredienteId) {
		ingredienteMap.remove(ingredienteId);
	}

	@Override
	public void addReceta(Receta r) {
		String id = "r" + index++;
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
		Receta receta = getReceta(recetaId);
		receta.addIngrediente(ingredienteMap.get(ingredienteId));
	}

	@Override
	public void removeIngrediente(String recetaId, String ingredienteId) {
		getReceta(recetaId).deleteIngrediente(ingredienteId);
	}

}
