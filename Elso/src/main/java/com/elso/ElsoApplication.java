package com.elso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElsoApplication.class, args);
		
		Bat denever = new Bat();
		process(denever);
	}

	
	public static void process(FlyAnimal animal) {
		animal.ascend();
	}
}
