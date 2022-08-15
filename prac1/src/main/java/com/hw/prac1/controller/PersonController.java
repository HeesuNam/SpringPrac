package com.hw.prac1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hw.prac1.domain.*;
import com.hw.prac1.service.PersonService;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personservice;

    @GetMapping("/api/persons")
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDTO requestDTO) {
        Person person = new Person(requestDTO);
        return personRepository.save(person);
    }

    @PutMapping("api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDTO requestDTO) {
        return personservice.update(id, requestDTO);
    }

    @DeleteMapping("api/persons/{id}")
    public Long deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);
        return id;
    }

}
