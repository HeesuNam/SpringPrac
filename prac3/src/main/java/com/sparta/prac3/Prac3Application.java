package com.sparta.prac3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Prac3Application {

	public static void main(String[] args) {
		SpringApplication.run(Prac3Application.class, args);
	}

}
