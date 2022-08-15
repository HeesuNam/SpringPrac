package com.hw.prac1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String job;

    public Person(String name, int age, String address, String job) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    public Person(PersonRequestDTO requestDTO) {
        this.name = requestDTO.getName();
        this.age = requestDTO.getAge();
        this.address = requestDTO.getAddress();
        this.job = requestDTO.getJob();
    }

    public void update(PersonRequestDTO requestDTO) {
        this.name = requestDTO.getName();
        this.age = requestDTO.getAge();
        this.address = requestDTO.getAddress();
        this.job = requestDTO.getJob();
    }
}
