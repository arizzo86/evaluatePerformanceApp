package com.griglie.evaluatePerformanceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing
@EntityScan("com.griglie.evaluatePerformanceApp.persistence.entities")
@EnableJpaRepositories("com.griglie.evaluatePerformanceApp.persistence.repositories")
public class EvaluatePerformanceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluatePerformanceAppApplication.class, args);
	}

}
