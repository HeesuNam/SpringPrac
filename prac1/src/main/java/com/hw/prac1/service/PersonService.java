package com.hw.prac1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.prac1.domain.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDTO personRequestDTO) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다"));
        person1.update(personRequestDTO);
        return person1.getId();
    }
}
