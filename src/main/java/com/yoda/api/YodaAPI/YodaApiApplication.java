package com.yoda.api.YodaAPI;

import com.yoda.api.YodaAPI.model.User;
import com.yoda.api.YodaAPI.resource.UserResource;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.rest.webmvc.ProfileResourceProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories(basePackages = "org.neo4j.example.repository")
@EnableTransactionManagement*/

@SpringBootApplication

@EnableNeo4jRepositories("com.yoda.api.YodaAPI.repository")
public class YodaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YodaApiApplication.class, args);
	}
/*
	@Bean
	public ProfileResourceProcessor<Resource> personProcessor() {

		return new ResourceProcessor<Resource<Person>>() {

			@Override
			public Resource<Person> process(Resource<Person> resource) {

				resource.add(new Link("http://localhost:8080/people", "added-link"));
				return resource;
			}
		};
	}
*/
}
