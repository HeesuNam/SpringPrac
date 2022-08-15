package com.hw.prac1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hw.prac1.domain.*;
import com.hw.prac1.service.PersonService;

@SpringBootApplication
public class Prac1Application {

	public static void main(String[] args) {
		SpringApplication.run(Prac1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
		return (args) -> {
			personRepository.save(new Person("남희수", 27, "수원", "학생"));

		};
	}
}
