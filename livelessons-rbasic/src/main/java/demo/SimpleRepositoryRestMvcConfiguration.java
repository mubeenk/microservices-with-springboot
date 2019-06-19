package demo;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class SimpleRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

	public SimpleRepositoryRestMvcConfiguration(ApplicationContext context,
			ObjectFactory<ConversionService> conversionService) {
		super(context, conversionService);
		// TODO Auto-generated constructor stub
	}

	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.exposeIdsFor(Person.class);
	}

}
