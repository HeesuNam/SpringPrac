package com.hw.prac2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CourseRequestDTO {
    private final String tilte;
    private final String tutor;
}
