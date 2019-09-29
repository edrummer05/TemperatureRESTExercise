package com.temperatures.temperatures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@ComponentScan(basePackageClasses = MainController.class)
@EnableJpaAuditing
public class TemperaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperaturesApplication.class, args);
	}

}
