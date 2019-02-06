package br.com.servico;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.entity.Conta;
import br.com.servico.Service;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

public class AtivaService extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public AtivaService() {
		//para swagger.
		BeanConfig conf = new BeanConfig();
		conf.setTitle("Criação e busca de contas");
		conf.setDescription("API para persistencia e busca de dados bancarios do sistema.");
		conf.setVersion("1.0.0");
		conf.setHost("localhost:8080");
		conf.setBasePath("/TesteWeb-0.0.1-SNAPSHOT/main/swagger/");
		conf.setSchemes(new String[] { "http" });
		conf.setResourcePackage("br.com.servico");
		conf.setScan(true);

		singletons.add(new Service());

	}

	//para o swagger.
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet();
		resources.add(Conta.class);

		// classes do swagger...
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;
	}

	public Set<Object> getSingletons() {
		return singletons;

	}

	public Set<Class<?>> getEmpty() {
		return empty;
	}
}
