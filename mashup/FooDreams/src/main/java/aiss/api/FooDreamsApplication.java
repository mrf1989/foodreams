package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import aiss.api.resources.RecipeResource;

public class FooDreamsApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public FooDreamsApplication() {

		singletons.add(RecipeResource.getInstance());
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
