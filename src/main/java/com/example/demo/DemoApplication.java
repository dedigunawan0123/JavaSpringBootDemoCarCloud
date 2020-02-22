package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CarRepository repository) {
		return (args)->{
			repository.save(new Car("Toyota", "Avanza", "black", "premium", 2019));
			repository.save(new Car("Honda", "Brio", "white", "pertamax", 2020));
			
		};
	}
}
