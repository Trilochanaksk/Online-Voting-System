package com.fswt.onlinevotingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.fswt.onlinevotingsystem", "com.project.onlinevotingsystem"})
@EnableJpaRepositories
public class OnlinevotingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinevotingsystemApplication.class, args);
	}

}
