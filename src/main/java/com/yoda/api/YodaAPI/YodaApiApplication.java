package com.yoda.api.YodaAPI;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories(basePackages = "org.neo4j.example.repository")
@EnableTransactionManagement*/
@SpringBootApplication
public class YodaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YodaApiApplication.class, args);
	}
/*
	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory(configuration(), "com.yoda.api.YodaAPI.model");
	}

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		ConfigurationSource properties = new ClasspathConfigurationSource("ogm.properties");
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties).build();
		return configuration;
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}
*/
}
