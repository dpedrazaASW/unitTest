package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("com.example.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
