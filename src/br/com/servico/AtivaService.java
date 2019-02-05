package br.com.servico;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class AtivaService extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public AtivaService() {

		singletons.add(new Service());

	}

	public Set<Object> getSingletons() {

		return singletons;

	}

	public Set<Class<?>> getEmpty() {

		return empty;

	}
}
