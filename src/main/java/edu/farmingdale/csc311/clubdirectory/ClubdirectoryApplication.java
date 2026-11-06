package edu.farmingdale.csc311.clubdirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.farmingdale.csc311"})
@EnableJpaRepositories(basePackages = {"edu.farmingdale.csc311.club"})
@EntityScan(basePackages = {"edu.farmingdale.csc311.club"})
public class ClubdirectoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClubdirectoryApplication.class, args);
	}

}
