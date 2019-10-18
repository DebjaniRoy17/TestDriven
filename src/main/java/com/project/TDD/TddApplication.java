package com.project.TDD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.TDD.model.TDDModel;
import com.project.TDD.repo.TDDRepository;

@SpringBootApplication
public class TddApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddApplication.class, args);
	}
	
	/* Uncomment these lines when you are executing the actual application
	 * 
	 * 
	 * @Bean public CommandLineRunner setup(TDDRepository tddRepository) { return
	 * (args) -> { tddRepository.save(new TDDModel("Abc", "Company1"));
	 * tddRepository.save(new TDDModel("Def", "Company2")); tddRepository.save(new
	 * TDDModel("Ghi", "Company3")); tddRepository.save(new TDDModel("Xyz",
	 * "Company4")); }; }
	 */

}
