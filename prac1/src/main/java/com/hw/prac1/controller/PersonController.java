package com.hw.prac1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/")
    public Person getPerson() {
        Person person = new Person();
        person.setName("남희수");
        person.setAge(27);
        person.setAddress("수원");
        person.setJob("학생");

        return person;
    }
}
