package com.glaucus.SpringRESTService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author rishirajsahu
 *
 *         Application Init Class, responsible for loading config and turning up
 *         the service
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.glaucus.model" })
@ComponentScan({ "com.glaucus" })
@EnableJpaRepositories(basePackages = { "com.glaucus.repository" })
@EnableTransactionManagement
public class SpringRestServiceApplication {

	public static void main(String[] args) {
		System.out.println("Starting The RestService");
		SpringApplication.run(SpringRestServiceApplication.class, args);
	}

}
