package com.hw.prac1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDTO {
    private final String name;
    private final int age;
    private final String address;
    private final String job;
}
